// def buildJar() {
//     echo 'building the application...'
//     sh 'mvn package'
// }

// def buildImage() {
//     echo "building the docker image..."
//     withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
//         sh 'docker build -t vaccine89/demo-app:5.0 .'
//         sh 'echo $PASS | docker login -u $USER --password-stdin'
//         sh 'docker push vaccine89/demo-app:5.0'
//     }
// }

// def deployApp() {
//     echo 'deploying the application...'
// }

// return this
