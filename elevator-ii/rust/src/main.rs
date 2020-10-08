mod control;
mod lib;

use crate::control::Control;
use crate::lib::{Building, Elevator, ElevatorControl, Instruction, Person};

fn main() {
    let people = [(0usize, vec![Person::new(200, 1)])]
        .iter()
        .cloned()
        .collect();
    let mut building = Building::new(100, people);

    let mut control = Control::new();
    let mut elevator = Elevator::new(1500, 5, &mut building, 0);

    let mut n = 0;
    while !elevator.is_empty() || !elevator.building().is_empty() {
        match control.get_instruction(&elevator) {
            Instruction::Up => {
                elevator.move_up();
            }
            Instruction::Down => {
                elevator.move_down();
            }
            Instruction::Open => {
                elevator.open_doors();
            }
        };
        n += 1;
    }

    println!("Took {} moves", n);
}
