#!/user/bin/env groovy
package com.example

class Docker implements Serializable {

    def script

    Docker(script) {
        this.script = script
    }

    def buildDockerImage(String imageName) {
        script.echo "[INFO] Building the docker image: $imageName"
        script.sh "docker build -t $imageName ."
    }

    def dockerLogin() {
        script.echo "[INFO] Running Docker Authentification.."
        script.withCredentials([script.usernamePassword(credentialsId: 'docker-hub-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]){
            script.sh 'echo "$PASS" | docker login -u "$USER" --password-stdin'
        }
    }

    def dockerPush(String imageName) {
        script.echo "[INFO] Pushing the docker image: $imageName"
        script.sh "docker push $imageName"
    }
}