PROGRAM test;

VAR
    i, j : integer;
    x, y : real;
    
BEGIN
    i := 1;
    j := 2;
    x := 3;
    y := 4;

    IF (i < j) THEN i := 0 ELSE j := 0;
    IF (x < y) THEN x := 0 ELSE y := 0;

END.
