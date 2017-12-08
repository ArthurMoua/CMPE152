PROGRAM sample;

VAR
    i, j, k, n : integer;
    alpha, beta5x : real;
    
BEGIN
    i := 32;
    j := i;
    i := -2 + 3*j;

    alpha := 9.3;
    beta5x := alpha;
    beta5x := alpha/3.7 - alpha*2.88;
    beta5x := 8.45*(alpha + 9.12);

    i := 100;
    j := 100;
    k := 500;
    n := 540;

    circle(i,j,k,n)


END.
