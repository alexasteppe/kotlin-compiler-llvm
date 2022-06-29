declare i32 @printf(i8*, ...)
declare i32 @scanf(i8*, ...)
@strpi = constant [4 x i8] c"%d\0A\00"
@strps = constant [4 x i8] c"%s\0A\00"
@strsi = constant [3 x i8] c"%d\00"
@strsd = constant [4 x i8] c"%lf\00"

@str0 = constant[17 x i8] c"2x*x + 4x + 10 \0A\00"
@str1 = constant[17 x i8] c"Enter x value: \0A\00"
@str2 = constant[10 x i8] c"Result: \0A\00"
define void @mathOperation() nounwind {
  %1 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ( [17 x i8], [17 x i8]* @str0, i32 0, i32 0))
  %2 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ( [17 x i8], [17 x i8]* @str1, i32 0, i32 0))
  %x = alloca i32
  store i32 0, i32* %x
  %3 = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @strsi, i32 0, i32 0), i32* %x)
  %res = alloca i32
  store i32 0, i32* %res
  %4 = load i32, i32* %x
  %5 = icmp sgt i32 %4, 0
  br i1 %5, label %true1, label %false1
  true1:
  %6 = load i32, i32* %x
  %7 = load i32, i32* %x
  %8 = load i32, i32* %x
  %9 = load i32, i32* %x
  %10 = mul i32 %9, 4
  %11 = mul i32 %10, %8
  %12 = mul i32 %11, %7
  %13 = add i32 10, %12
  %14 = add i32 %13, 2
  store i32 %14, i32* %res
  br label %false1
  false1:
  %15 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ( [10 x i8], [10 x i8]* @str2, i32 0, i32 0))
  %16 = load i32, i32* %res
  %17 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %16)
  ret void
}

@.str = private unnamed_addr constant [3 x i8] c"%d\00"
@str3 = constant[19 x i8] c"Old array value: \0A\00"
@str4 = constant[3 x i8] c" \0A\00"
@str5 = constant[19 x i8] c"New array value: \0A\00"
define void @arrayCheck() nounwind {
  %numbers= alloca [5x i32] 
  %1 = getelementptr inbounds [5 x i32], [5 x i32]* %numbers, i64 0, i64 0
  store i32 133, i32* %1
  %2 = getelementptr inbounds [5 x i32], [5 x i32]* %numbers, i64 0, i64 1
  store i32 22, i32* %2
  %3 = getelementptr inbounds [5 x i32], [5 x i32]* %numbers, i64 0, i64 2
  store i32 3, i32* %3
  %4 = getelementptr inbounds [5 x i32], [5 x i32]* %numbers, i64 0, i64 3
  store i32 41, i32* %4
  %5 = getelementptr inbounds [5 x i32], [5 x i32]* %numbers, i64 0, i64 4
  store i32 5, i32* %5
  %6 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ( [19 x i8], [19 x i8]* @str3, i32 0, i32 0))
  %7 = getelementptr inbounds [5 x i32], [5 x i32]* %numbers, i64 0, i64 0
  load i32, i32* %7
  %9 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str, i64 0, i64 0), i32 %8)
  %10 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ( [3 x i8], [3 x i8]* @str4, i32 0, i32 0))
  %11= getelementptr inbounds [5 x i32], [5 x i32]* %numbers, i64 0, i64 0
  store i32 12, i32* %11
  %12 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ( [19 x i8], [19 x i8]* @str5, i32 0, i32 0))
  %13 = getelementptr inbounds [5 x i32], [5 x i32]* %numbers, i64 0, i64 0
  load i32, i32* %13
  %15 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str, i64 0, i64 0), i32 %14)
  ret void
}

@str6 = constant[18 x i8] c"Kotlin Compiler!\0A\00"
define void @main() nounwind {
  %1 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ( [18 x i8], [18 x i8]* @str6, i32 0, i32 0))
  call void @mathOperation()
  call void @arrayCheck()
  ret void
}

