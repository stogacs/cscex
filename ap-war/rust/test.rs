use crate::under_vs_upper;

static UNDER_VICTORY: &str = "Underclassmen are victorious";
static UPPER_VICTORY: &str = "Upperclassmen are victorious";
static TIE: &str = "No victor on this battlefield";

macro_rules! run_test {
    ($under:expr, $upper:expr, $res:expr) => {
        assert_eq!(under_vs_upper($under, $upper), $res)
    };
}

#[test]
fn test_examples() {
    run_test!("0 0 0 0 10", "0 0 0 0 0", UNDER_VICTORY);
    run_test!("0 0 0 0 0", "0 0 0 0 10", UPPER_VICTORY);
    run_test!("0 0 0 0 10", "0 0 0 0 10", TIE);
}

#[test]
fn test_under_wins() {
    run_test!("1 0 1 0 0", "0 1 0 0 0", UNDER_VICTORY);
}

#[test]
fn test_upper_wins() {
    run_test!("0 1 0 0 1", "0 0 0 1 1", UPPER_VICTORY);
}

#[test]
fn test_tie() {
    run_test!("0 0 1 0 1", "1 0 1 1 0", TIE);
    run_test!("2 0 4 0 5", "6 2 2 0 3", TIE);
}
