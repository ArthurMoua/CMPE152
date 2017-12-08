.class public sample
.super java/lang/Object

.field private static _runTimer LRunTimer;
.field private static _standardIn LPascalTextIn;

; i,j,k,n:integer

.field private static i I
.field private static j I
.field private static k I
.field private static n I

; alpha,beta5x:real

.field private static alpha F
.field private static beta5x F

.method public <init>()V

	aload_0
	invokenonvirtual    java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

.method public static main([Ljava/lang/String;)V

	new javax/swing/JFrame
	dup
	ldc "Team Last Minute - Best Object drawing ever!"
	invokespecial javax/swing/JFrame/<init>(Ljava/lang/String;)V
	astore_1

	aload_1
	sipush 640
	sipush 480
	invokevirtual javax/swing/JFrame/setSize(II)V

	aload_1
	iconst_3
	invokevirtual javax/swing/JFrame/setDefaultCloseOperation(I)V

	aload_1
	iconst_1
	invokevirtual javax/swing/JFrame/setVisible(Z)V


; i:=32

	ldc	32
	putstatic	sample/i I

; j:=i

	getstatic	sample/i I
	putstatic	sample/j I

; i:=-2+3*j

	ldc	2
	ineg
	ldc	3
	getstatic	sample/j I
	imul
	iadd
	putstatic	sample/i I

; alpha:=9.3

	ldc	9.3
	putstatic	sample/alpha F

; beta5x:=alpha

	getstatic	sample/alpha F
	putstatic	sample/beta5x F

; beta5x:=alpha/3.7-alpha*2.88

	getstatic	sample/alpha F
	ldc	3.7
	fdiv
	getstatic	sample/alpha F
	ldc	2.88
	fmul
	fsub
	putstatic	sample/beta5x F

; beta5x:=8.45*(alpha+9.12)

	ldc	8.45
	getstatic	sample/alpha F
	ldc	9.12
	fadd
	fmul
	putstatic	sample/beta5x F

; i:=100

	ldc	100
	putstatic	sample/i I

; j:=100

	ldc	100
	putstatic	sample/j I

; k:=500

	ldc	500
	putstatic	sample/k I

; n:=540

	ldc	540
	putstatic	sample/n I

; circle(i,j,k,n)

	new drawCir
	dup
	getstatic	sample/i I
	getstatic	sample/j I
	getstatic	sample/k I
	getstatic	sample/n I
	invokespecial drawCir/<init>(IIII)V
	astore_2

	aload_1
	aload_2
	invokevirtual javax/swing/JFrame/add(Ljava/awt/Component;)Ljava/awt/Component;
	pop


	return

.limit locals 16
.limit stack 16
.end method
