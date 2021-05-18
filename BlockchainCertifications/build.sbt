name := """BlockchainCertifications"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.5"

libraryDependencies += guice

// Java project. Don't expect Scala IDE
EclipseKeys.projectFlavor := EclipseProjectFlavor.Java

// Use .class files instead of generated .scala files for views and routes
EclipseKeys.createSrc := EclipseCreateSrc.ValueSet(EclipseCreateSrc.ManagedClasses, EclipseCreateSrc.ManagedResources)

//enable the database plugin
libraryDependencies ++= Seq(
  javaJdbc
)

//
libraryDependencies ++= Seq(
  "mysql" % "mysql-connector-java" % "5.7.31"
)