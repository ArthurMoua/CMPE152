.class public sampleS
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


; i:=100+25

	ldc	100
	ldc	25
	iadd
	putstatic	sampleS/i I

; j:=100+25

	ldc	100
	ldc	25
	iadd
	putstatic	sampleS/j I

; k:=500-200

	ldc	500
	ldc	200
	isub
	putstatic	sampleS/k I

; n:=540-240

	ldc	540
	ldc	240
	isub
	putstatic	sampleS/n I

; square(i,j,k,n)

	new drawRec
	dup
	getstatic	sampleS/i I
	getstatic	sampleS/j I
	getstatic	sampleS/k I
	getstatic	sampleS/n I
	invokespecial drawRec/<init>(IIII)V
	astore_2

	aload_1
	aload_2
	invokevirtual javax/swing/JFrame/add(Ljava/awt/Component;)Ljava/awt/Component;
	pop


	return

.limit locals 16
.limit stack 16
.end method
