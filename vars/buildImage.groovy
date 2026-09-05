#!/user/bin/env groovy

def call() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]){
        sh 'docker build -t aagargoura/demo-app:jma-2.2 .'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push aagargoura/demo-app:jma-2.2'
    }
}