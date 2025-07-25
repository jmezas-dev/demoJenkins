#!groovy
pipeline {
    agent any
    environment {
        REGISTRY = 'jmezas/springservice'
        NEW_VERSION = '1.0.0'
    }
    tools {
        maven 'Maven'
    }
    parameters {
        choice(name:'VERSION', choices:['1.1.0', '1.2.0', '1.3.0'], description:'')
        booleanParam(name:'executeTests', defaultValue:true, description: 'Executes tests if true')
    }
    stages {
        stage("Checkout Github"){
            steps {
                git credentialsId: 'gh-credential', url: 'https://github.com/jmezas-dev/demoJenkins.git'
            }
        }
        stage("test") {
            agent any
            when {
                expression {
                    params.executeTests == true
                }
            }
            steps {
                echo "testing the application"
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage("build") {
            agent any
            steps {
                echo "building the application v${NEW_VERSION}"
                sh "docker build -t ${REGISTRY}:${NEW_VERSION} ."
            }
        }
        stage("deploy") {
            agent any
            steps {
                echo "deploying the application ${params.VERSION}"
                script {
                    withCredentials([string(credentialsId: 'docker', variable: 'CREDENTIALS')]) {
                        sh "docker login --username jmezas -p ${CREDENTIALS}"
                        sh "docker tag ${REGISTRY} ${REGISTRY}:latest"
                        sh "docker push ${REGISTRY}:latest"
                    }
                }
            }
        }
    }
}