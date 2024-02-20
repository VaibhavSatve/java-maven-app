def gv

pipeline {   
  agent any
  tools {
    maven 'Maven'
  }
  stages {
    stage("init") {
      steps {
      script {
        gv = load "script.groovy"
        }
      }
    }
    stage("build jar") {
      steps {
        script {
          echo 'building application jar...'
          buildJar()
        }
      }
    }
    stage("build image") {
      steps {
        script {
          echo 'building docker image...'
          buildImage()
          dockerLogin()
          dockerPush()
        }
      }
    }
    stage("deploy") {
      steps {
        script {
          echo 'deploying docker image to EC2...'
        }
      }
    }               
  }
}
