name := """BlockchainCertifications"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.5"

//libraryDependencies += guice

// Java project. Don't expect Scala IDE
EclipseKeys.projectFlavor := EclipseProjectFlavor.Java

// Use .class files instead of generated .scala files for views and routes
EclipseKeys.createSrc := EclipseCreateSrc.ValueSet(EclipseCreateSrc.ManagedClasses, EclipseCreateSrc.ManagedResources)

//Morphia configuration
libraryDependencies ++= Seq(
    guice,
    "org.mongodb" % "mongo-java-driver" % "3.12.0",
    "dev.morphia.morphia" % "core" % "1.5.8",
    )
    
//

libraryDependencies ++= Seq(
  "org.reactivemongo" %% "play2-reactivemongo" % "0.20.13-play28"
)
