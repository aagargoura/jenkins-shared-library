#!/user/bin/env groovy

def call() {
    echo 'Building the Jar..'
    sh 'mvn package'
}