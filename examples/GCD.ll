declare i32 @printf(i8*, ...)
declare i32 @scanf(i8*, ...)
@strpi = constant [4 x i8] c"%d\0A\00"
@strps = constant [4 x i8] c"%s\0A\00"
@strsi = constant [3 x i8] c"%d\00"
@strsd = constant [4 x i8] c"%lf\00"

define void @main() nounwind {
  %n = alloca i32
  store i32 81, i32* %n
  %m = alloca i32
  store i32 153, i32* %m
  %1 = load i32, i32* %n
  %2 = load i32, i32* %m
  %3 = icmp sgt i32 %1, %2
  br i1 %3, label %true1, label %false1
  true1:
  %4 = load i32, i32* %n
  %5 = load i32, i32* %m
  %6 = load i32, i32* %n
  %7 = load i32, i32* %m
  %8 = sub i32 %6, %7
  store i32 %8, i32* %n
  br label %false1
  false1:
  %9 = load i32, i32* %n
  %10 = load i32, i32* %m
  %11 = icmp slt i32 %9, %10
  br i1 %11, label %true2, label %false2
  true2:
  %12 = load i32, i32* %n
  %13 = load i32, i32* %m
  %14 = load i32, i32* %n
  %15 = load i32, i32* %m
  %16 = load i32, i32* %n
  %17 = load i32, i32* %m
  %18 = load i32, i32* %m
  %19 = load i32, i32* %n
  %20 = sub i32 %18, %19
  %21 = sub i32 %17, %20
  store i32 %21, i32* %m
  br label %false2
  false2:
  %22 = load i32, i32* %n
  %23 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %22)
  ret void
}

