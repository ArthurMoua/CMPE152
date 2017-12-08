.class public testif
.super java/lang/Object

.field private static _runTimer LRunTimer;
.field private static _standardIn LPascalTextIn;

; i,j,k,n:integer

.field private static i I
.field private static j I
.field private static k I
.field private static n I

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


; i:=1

	ldc	1
	putstatic	testif/i I

; j:=2

	ldc	2
	putstatic	testif/j I

; k:=3

	ldc	3
	putstatic	testif/k I

; n:=4

	ldc	4
	putstatic	testif/n I

; ifi<>jthenk:=0elsen:=0

	getstatic	testif/i I
	getstatic	testif/j I
this is a test

; k:=0

	ldc	0
	putstatic	testif/k I

; n:=0

	ldc	0
	putstatic	testif/n I


	return

.limit locals 16
.limit stack 16
.end method
