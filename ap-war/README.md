# AP War

The underclassmen and upperclassmen are going to war. There is only one
factor that will determine who comes out victorious: the number of AP
classes taken.

However, not all AP classes are worth the same.

On the side of the underclassmen, the subject areas have the following
worth:

- English: 0
- Mathematics: 3
- Foreign Language: 5
- Science: 6
- Social Studies: 8

On the side of the upperclassmen, the subject areas have the following
worth:

- Social Studies: 3
- English: 4
- Foreign Language: 5
- Mathematics: 5
- Science: 8

If you add up the worth of the side of the underclassmen and compare it
with the worth of the side of upperclassmen, the side with the larger
worth will surely win.

Thus, given the count of each of the AP course subjects taken on the
side of the underclassmen, followed by the count of each of the AP
course subjects on the side of the upperclassmen, determine which side
wins.

## Input

The function will be given 2 parameters. Each parameter will be a string
of multiple integers separated by a single space. Each string will
contain the count of each AP course subject taken on the side of the
underclassmen and upperclassmen.

The first parameter will contain the count of each AP course subject
taken on the side of the underclassmen in the following order:

English, Mathetmatics, Foreign Language, Science, Social Studies.

The second parameter will contain the count of each AP course subject
taken on the side of the upperclassmen in the following order:

Social Studies, English, Foreign Language, Mathematics, Science.

All values are non-negative integers. The resulting sum of the worth for
each side will not exceed the limit of a 32-bit integer.

## Output

Return `"Underclassmen are victorious"`if the underclassmen win, or
`"Upperclassmen are victorious"`if the upperclassmen win, or
`"No victor on this battlefield"` if it ends in a tie.

## Test Cases

Some example test cases:

    assert  under_vs_upper("0 0 0 0 0 10", "0 0 0 0 0 0 0") == "Underclassmen are victorious"
    assert  under_vs_upper("0 0 0 0 0 0", "0 0 0 0 0 0 10") == "Upperclassmen are victorious"
    assert  under_vs_upper("0 0 0 0 0 10", "0 0 0 0 0 0 10") == "No victor on this battlefield"

## Disclaimer(s)

The worth values assigned to subject areas are arbitrary and do not
necessarily represent the views of the question writer.

The question writer is not promoting antagonistic relations between
underclassmen and upperclassmen.
