PROGRAM test;

VAR
    i, j, k, n : integer;
    
BEGIN
    i := 1;
    j := 5;

    while i < 5 do i:=i+1;

    i := 1;
    j := 5;

    while i <= 5 do i:=i+1;

    i := 10;
    j := 5;

    while i > 5 do i:=i-1;

    i := 10;
    j := 5;

    while i >= 5 do i:=i-1;

    i := 1;
    j := 5;

    while i <> 5 do i:=i+1;

    i := 1;
    j := 5;

    while i = 5 do i:=i+1;

    
    i := 100;
    j := 100;
    k := 500;
    n := 540;

    circle(i,j,k,n)


END.
