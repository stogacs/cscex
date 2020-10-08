use crate::lib::{Elevator, ElevatorControl, Instruction};

#[derive(Debug, Clone)]
pub struct Control;

impl Control {
    pub fn new() -> Self {
        Self
    }
}

impl ElevatorControl for Control {
    #[allow(unused_variables)]
    fn get_instruction(&mut self, elevator: &Elevator) -> Instruction {
        unimplemented!()
    }
}
