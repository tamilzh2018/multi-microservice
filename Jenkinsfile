pipeline {
    agent any

    environment {
        VERSION = "${env.BUILD_NUMBER}"
    }

    stages {
        stage("Git Checkout") {
            steps {
                git 'https://github.com/tamilzh2018/multi-microservice.git'
            }
        }

        stage('Docker Build & Push') {
            steps {
                script {
                    // Securely retrieve Docker credentials
                    withCredentials([
                        string(credentialsId: 'docker-username', variable: 'DOCKER_USER'),
                        string(credentialsId: 'docker-password', variable: 'DOCKER_PASS'),
                        string(credentialsId: 'docker-registry', variable: 'DOCKER_URL')
                    ]) {
                        // Docker login command, ensuring secure login
                        sh """
                            echo "Logging into Docker registry..."
                            if echo ${env.DOCKER_PASS} | docker login --username ${env.DOCKER_USER} --password-stdin ${env.DOCKER_URL}; then
                                echo "Login successful!"
                            else
                                echo "Login failed."
                            fi

                            echo "Building Nginx Docker image..."
                            docker build -t ${env.DOCKER_URL}/nginx:${env.BUILD_NUMBER} api-gateway/nginx/

                            echo "Pushing Docker image..."
                            docker push ${env.DOCKER_URL}/nginx:${env.BUILD_NUMBER}

                            echo "Removing Docker image locally..."
                            docker rmi ${env.DOCKER_URL}/nginx:${env.BUILD_NUMBER}

                            echo "Building Java Docker image..."
                            docker build -t ${env.DOCKER_URL}/java-api:${env.BUILD_NUMBER} java-api/

                            echo "Pushing Docker image..."
                            docker push ${env.DOCKER_URL}/java-api:${env.BUILD_NUMBER}

                            echo "Removing Docker image locally..."
                            docker rmi ${env.DOCKER_URL}/java-api:${env.BUILD_NUMBER}
							
							echo "Building csharp-api Docker image..."
                            docker build -t ${env.DOCKER_URL}/csharp-api:${env.BUILD_NUMBER} csharp-api/

                            echo "Pushing Docker image..."
                            docker push ${env.DOCKER_URL}/csharp-api:${env.BUILD_NUMBER}

                            echo "Removing Docker image locally..."
                            docker rmi ${env.DOCKER_URL}/csharp-api:${env.BUILD_NUMBER}
							
							echo "Building NodeJs Docker image..."
                            docker build -t ${env.DOCKER_URL}/nodejs-api:${env.BUILD_NUMBER} nodejs-api/

                            echo "Pushing Docker image..."
                            docker push ${env.DOCKER_URL}/nodejs-api:${env.BUILD_NUMBER}

                            echo "Removing Docker image locally..."
                            docker rmi ${env.DOCKER_URL}/nodejs-api:${env.BUILD_NUMBER}
							
							echo "Building csharp-api Docker image..."
                            docker build -t ${env.DOCKER_URL}/python-api:${env.BUILD_NUMBER} python-api/

                            echo "Pushing Docker image..."
                            docker push ${env.DOCKER_URL}/python-api:${env.BUILD_NUMBER}

                            echo "Removing Docker image locally..."
                            docker rmi ${env.DOCKER_URL}/python-api:${env.BUILD_NUMBER}
                        """
                    }
                }
            }
        }
    }
}
