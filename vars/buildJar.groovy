#!/user/bin/env groovy

def call() {
    echo "[INFO] Building the Application for branch: $GIT_BRANCH"
    sh 'mvn package'
}