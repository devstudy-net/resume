# My Resume

Учебный проект для курса http://devstudy.net/course/jee-resume

## Инструкция по запуску проекта в docker контейнерах

Для сборки и запуска данного проекта в docker контейнерах на компьютер необходимо установить ТОЛЬКО **docker** и **docker-compose**. 
Все необходимые для сборки и запуска программные компоненты доступны в виде docker образов на docker hub и поэтому **docker** подтянет их из интернета. 

*Т.е. на компьютер **НЕ НУЖНО устанавливать** git, java, maven, tomcat, mongodb и nginx.*


### Настройка системы разработчика:

Установка **docker** зависит от операционной системы, поэтому на официальном сайте необходимо выбрать Вашу операционную систему и следуя инструкциям установить **docker** и **docker-compose**:

* [Инструкция по установке docker](https://docs.docker.com/install/#supported-platforms)
* [Инструкция по установке docker-compose](https://docs.docker.com/compose/install/#install-compose)

FYI: Для операционных сиситем на базе **Ubuntu** можно использовать упрощенные команды:

* Установка **docker** одной командой: 
~~~~
sudo apt update && sudo apt install -y docker.io && sudo systemctl start docker
~~~~
* Установка **docker-compose** одной командой: 
~~~~
sudo apt install -y curl && sudo curl -L "https://github.com/docker/compose/releases/download/1.24.1/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose && sudo chmod +x /usr/local/bin/docker-compose
~~~~

### Сборка и запуск проекта:

###### 0. Для запуска docker команды на Linux необходимы привелегии root:
~~~~
sudo usermod -aG docker $USER
~~~~
###### 1. Клонировать github репозиторий в текущую папку с помощью docker образа devstudy/git:
~~~~
docker run -it --rm -u 1000 -v "$PWD":/opt/src/ -w /opt/src devstudy/git git clone "https://github.com/devstudy/resume"
~~~~
###### 2. Изменить текущую папку на корневую папку проекта:
~~~~
cd resume/
~~~~
###### 3. Собрать проект с помощью maven с помощью docker образа devstudy/maven:
~~~~
docker run -v ~/:/home/mvn/ -it --rm -u 1000 -e MAVEN_CONFIG=/home/mvn/.m2 -v "$PWD":/opt/src/ -w /opt/src devstudy/maven mvn -Duser.home=/home/mvn clean package
~~~~
###### 4. Создать файл .env в папке resume и указать переменные окружения:
*(Если данный файл не создавать в проекте не будут работать модули **email** и **facebook**):*
~~~~
DEVSTUDY_RESUME_FACEBOOK_CLIENT_ID=TODO
DEVSTUDY_RESUME_FACEBOOK_SECRET=TODO

DEVSTUDY_RESUME_SMTP_USERNAME=TODO
DEVSTUDY_RESUME_SMTP_PASSWORD=TODO
~~~~
###### 5. Собрать и запустить docker контейнеры:
~~~~
docker-compose up
~~~~

*P.S. Если сборка и запуск docker контейнеров прошли успешно в консоли последней строчкой Вы должны увидеть строку, что Resume-backend server успешно запустился:*

`resume-backend     | 30-Jul-2019 16:31:26.917 INFO [main] org.apache.catalina.startup.Catalina.start Server startup in 22079 ms` 

###### 6. Открыть браузер и зайти на сайт:
* Если **docker** устанавливался на текущую машину, то адрес сайта: `http://localhost`
* Если **docker** устанавливался на удаленную машину, то адрес сайта: `http://${REMOTE_IP_ADDRESS}`

###### 7. Если нужно отлаживать проект, то по-умолчанию docker-compose открывает следующие порты:

* 27017 - для доступа к mongo базе данных, с помощью mongo клиента;
* 8080 - для доступа к серверу Tomcat напрямую, минуя nginx;
* 8765 - для tomcat remote debugging 

###### 8. Чтобы остановить docker контейнеры:
~~~~
Ctrl+C
~~~~

###### 9. Чтобы удалить docker контейнеры:
~~~~
docker-compose down
~~~~

### Удаление исходников проекта:

Если на сервере нужны только docker контейнеры с готовыми образами приложения, то исходники которые уже не будут использоваться при запуске проекта могут быть удалены

###### 1. Удалить docker образ с установленным git:
~~~~
docker rmi -f devstudy/git
~~~~
###### 2. Удалить docker образ с установленным maven:
~~~~
docker rmi -f devstudy/maven
~~~~
###### 3. Удалить все файлы проекта кроме ./docker и ./docker-compose.yml:
~~~~
rm -rf ./src ./target ./pom.xml ./external ./TODO ./README.md ./.git ./.gitignore
~~~~
###### 4. Удалить локальный maven репозиторий:
~~~~
rm -rf ~/.m2
~~~~

### Запуск проекта в случае наличия готовых образов в локальном docker хранилище

###### 1. Запустить docker контейнеры:
~~~~
docker-compose up
~~~~
###### 2. Остановить docker контейнеры:
~~~~
Ctrl+C
~~~~

###### 3. Удалить docker контейнеры:
~~~~
docker-compose down
~~~~