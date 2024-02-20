pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    stages {
        stage("Test") {
            steps {
                script {
                    echo 'Testing the Application'
                    echo "Executing the pipeline for the Main Branch"
                }
            }
        }
        stage("build jar") {
            steps {
                script {
                    echo "Building the Application"
                    sh 'mvn package'
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                        echo "Building Image for application"
                        sh 'docker build -t vaccine89/demo-app:5.0 .'
                        sh 'echo $PASS | docker login -u $USER --password-stdin'
                        sh 'docker push vaccine89/demo-app:5.0'
                    }
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    echo "Deploying Application"
                }
            }
        }
    }
}
