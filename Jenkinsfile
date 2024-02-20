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
                    echo "Executing the pipeline for the Current Branch $BRANCH_NAME"
                }
            }
        }
        stage("build jar") {
            when {
                expression {
                    env.BRANCH_NAME == 'main'
                }
            }
            steps {
                script {
                    echo "Building the Application"
                    sh 'mvn package'
                }
            }
        }
        stage("build image") {
            when {
                expression {
                    env.BRANCH_NAME == 'main'
                }
            }
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
            when {
                expression {
                    env.BRANCH_NAME == 'main'
                }
            }
            steps {
                script {
                    echo "Deploying Application"
                }
            }
        }
    }
}
