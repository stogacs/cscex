#![allow(unused)]

use std::collections::HashMap;

pub trait ElevatorControl {
    fn get_instruction(&mut self, elevator: &Elevator) -> Instruction;
}

#[derive(Debug, Clone)]
pub enum Instruction {
    Up,
    Down,
    Open,
}

#[derive(Debug)]
pub struct Building {
    people: HashMap<usize, Vec<Person>>,
    floors: usize,
}

impl Building {
    pub fn new(floors: usize, people: HashMap<usize, Vec<Person>>) -> Self {
        Self { floors, people }
    }

    pub fn people(&self) -> &HashMap<usize, Vec<Person>> {
        &self.people
    }

    pub fn total_floors(&self) -> usize {
        self.floors
    }

    pub fn is_empty(&self) -> bool {
        self.people.is_empty()
    }
}

#[derive(Debug)]
pub struct Elevator<'a> {
    weight_capacity: u32,
    num_capacity: u32,

    building: &'a mut Building,
    passengers: Vec<Person>,

    current_floor: usize,
}

impl<'a> Elevator<'a> {
    pub fn new(
        weight_capacity: u32,
        num_capacity: u32,
        building: &'a mut Building,
        current_floor: usize,
    ) -> Self {
        Self {
            weight_capacity,
            num_capacity,
            building,
            passengers: Vec::new(),
            current_floor,
        }
    }

    pub fn weight_capacity(&self) -> u32 {
        self.weight_capacity
    }

    pub fn num_capacity(&self) -> u32 {
        self.num_capacity
    }

    pub fn building(&self) -> &Building {
        self.building
    }

    pub fn passengers(&self) -> &Vec<Person> {
        &self.passengers
    }

    pub fn current_floor(&self) -> usize {
        self.current_floor
    }

    pub fn is_empty(&self) -> bool {
        self.passengers.is_empty()
    }

    pub fn move_up(&mut self) -> Option<()> {
        match self.current_floor {
            x if x == self.building.floors => None,
            _ => {
                self.current_floor += 1;
                Some(())
            }
        }
    }

    pub fn move_down(&mut self) -> Option<()> {
        match self.current_floor {
            x if x == 1 => None,
            _ => {
                self.current_floor -= 1;
                Some(())
            }
        }
    }

    pub fn open_doors(&mut self) {
        let leaving: Vec<_> = self
            .passengers
            .iter()
            .filter(|p| p.dest == self.current_floor)
            .enumerate()
            .map(|(i, _)| i)
            .collect();
        for i in leaving {
            self.passengers.remove(i);
        }

        let mut waiting = match self.building.people.remove(&self.current_floor) {
            Some(v) => v,
            None => vec![],
        };
        waiting.sort_by(|a, b| a.dest.cmp(&b.dest));

        let mut first = false;
        for p in waiting.into_iter() {
            let q = self.add_person(p);
            match q {
                Some(v) => {
                    if first {
                        self.building.people.insert(self.current_floor, vec![v]);
                        first = true;
                    } else {
                        let l = self.building.people.get_mut(&self.current_floor).unwrap();
                        l.push(v);
                    }
                }
                None => break,
            }
        }
    }

    fn add_person(&mut self, person: Person) -> Option<Person> {
        if (self.passengers.len() == self.num_capacity as usize)
            || (self.total_weight() + person.weight > self.weight_capacity)
        {
            Some(person)
        } else {
            self.passengers.push(person);
            None
        }
    }

    fn total_weight(&self) -> u32 {
        self.passengers.iter().map(|p| p.weight).sum()
    }
}

#[derive(Debug, Clone)]
pub struct Person {
    weight: u32,
    dest: usize,
}

impl Person {
    pub fn new(weight: u32, dest: usize) -> Self {
        Self { weight, dest }
    }

    pub fn weight(&self) -> u32 {
        self.weight
    }

    pub fn dest(&self) -> usize {
        self.dest
    }
}
