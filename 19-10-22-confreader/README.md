# Conf Reader

In this exercise, you will parse a configuration file format (that we came up with)
into some kind of map object in your language of choice.

There are two types of files, as described below. 
Writing a solution for Type 1 will award **35 points**; 
a solution for Type 2 will award **60 points**.

## Starter Code

Minimal starter code has been provided for Java, Python, JavaScript, Typescript, PHP, Ruby, and C#, but you may use any
language you wish. 

# Configuration Types

## Configuration Type 1

This type is found in the file `conf-t1`.

Each configuration property is defined by `key = value`.
No semicolon or comma or anything marks the end of the line.

Valid types are:

- `string` : surrounded by double quotes (" "); ex: `"John"`
- `integer` : ex: `13`
- `floating point` : ex: `23.20`
- `boolean` : ex: `true`

Nested properties are allowed; they are surrounded by curly braces (`{` and `}`).
The nested properties themselves will be on their own lines:

```
key = {
    nested-key-1 = "value-1"
    nested-key-2 = 2
    nested-key-3 = {
        nested-nested-key = "value-4"
    }
    nested-key-4 = false
}
```

Arrays are allowed and may be nested. Elements may be of different types.
They are surrounded by square brackets (`[` and `]`). 
Elements are **not** separated by commas, they are simply on separate lines.

```
key = [
    6.4
    true
    "yes"
    [
        2
        "another nested array element"
    ]
]
```

Lines beginning with the character `#` are considered comments are should 
ignored by parsers.

Blank lines should also be ignored.

**Indentation does not matter.**

### Example File

```
# Configuration file for server options

port = 8080
hostname = "0.0.0.0"
db = {
    path = "/tmp/a.db"
    create = true
}

refresh = 3
allowed-hosts = [
    "1.1.1.1"

    "2.2.2.2"
    [
        "3.3.3.3"
    ]
]
```

## Configuration Type 2

All syntax rules described for type 1 exist in type 2, so read the above section,
except for two exceptions:

Nested properties are still surrounded by curly braces, but may be written on a
single line with key-value pairs separated by commas:

```
key = {
    nested-key-1 = "value-1"
#   ...
    nested-key-3 = {
        nested-nested-key = "value-4"
    }
    nested-key-5 = { a = "2", b = false }
}
```

Similarly, arrays may be written on a single line with elements separated by commas:

```
key = [
    6.4
    true
    "yes"
    [
        2
        "another nested array element"
    ]
    [ "sixteen", 16, false ]
]
```

## Mapping to Class / Struct

For bonus points (maybe another **30 points** or something), allow parsing of the configuration properties into a user-defined class or struct. 

Typically, this would require reflection.
Languages such as Java, Python, and Go all provide reflection capabilities in their 
standard libraries.

For example, if you have this configuration file:

```
port = 8080
hostname = "0.0.0.0"
db = {
    path = "/tmp/a.db"
    create = true
}
```

The user may define a class that mirrors this file. 
Consider this Java code:

```java
public class Conf {
    private int port;
    private String hostname;
    private DBConf db;
}

class DBConf {
    private String path;
    private boolean create;
}
```

Thus, something like this might store a `Conf` object in the variable `c` whose
properties mirror those specified in the configuration file.

```java
// ...

ConfReader reader = new ConfReader();
Conf c = reader.parse(new File("conf"), Conf.class);

// ...
```