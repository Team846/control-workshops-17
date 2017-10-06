enablePlugins(FRCPlugin)

name := "workshops"

scalaVersion := "2.12.3"

resolvers += "Funky-Repo" at "http://team846.github.io/repo"
resolvers += "WPILib-Maven" at "http://team846.github.io/wpilib-maven"
resolvers += "opencv-maven" at "https://github.com/WPIRoboticsProjects/opencv-maven/raw/mvn-repo"

organization := "com.lynbrookrobotics"
teamNumber := 846

val potassiumVersion = "0.1.0-8543809b"
libraryDependencies += "com.lynbrookrobotics" %% "potassium-core" % potassiumVersion
libraryDependencies += "com.lynbrookrobotics" %% "potassium-commons" % potassiumVersion
libraryDependencies += "com.lynbrookrobotics" %% "potassium-frc" % potassiumVersion

libraryDependencies += "edu.wpi.first" % "wpilib" % "2017.3.1"
libraryDependencies += "edu.wpi.first" % "networktables" % "2017.3.1"
libraryDependencies += "edu.wpi.first" % "cscore" % "2017.3.1"
libraryDependencies += "com.ctre" % "ctrlib" % "4.4.1.12"
libraryDependencies += "org.opencv" % "opencv-java" % "3.1.0"