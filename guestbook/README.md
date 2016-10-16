# WeatherReport

This is a simple web project showing basic usage of web technologies. It displays weather for three cities using Yahoo weather API.

## Prerequisites
0. [Download and install](http://maven.apache.org/) Maven if you don't have it installed.

1. Install the [Google Cloud SDK](https://cloud.google.com/sdk/) on your machine. The new Maven plugin
goals will not download it automatically on build. Make sure you install an
up-to-date version (Beta or later) that has the App Engine Managed VM components
installed.

2. Install the Cloud SDK app-engine-java component:

        gcloud components update app-engine-java

3. The Maven plugin relies on configuration done by the cloud SDK. For example, the project name
you want to use for a deployment step can be defined with:

      ```
      gcloud auth login
      gcloud config set project <your project name>
      ```

## Run Locally
   ```
   git clone https://github.com/gauravvijay/weather.git
   cd guestbook
   mvn clean install
   #to test it locally:
   mvn appengine:run   
   ```
Visit the application [http://localhost:8080/weather](http://localhost:8080/weather)

## Deploy
To deploy the application:

    mvn appengine:deploy
    
An live instance of the application is available [here](https://api-project-842690667110.appspot.com/weather).
