// Profiles
let profileResults = [
    db.profile.insert({
        uid: "aly-dutta",
        firstName: "Aly",
        lastName: "Dutta",
        birthDay: new Date("1989-04-08T15:44:39.176Z"),
        phone: "+380505477187",
        email: "aly-dutta@gmail.com",
        country: "Ukraine",
        city: "Kiyv",
        objective: "Junior java developer position",
        summary: "One Java professional course with developing web application resume (Link to demo is provided)",
        largePhoto: "/media/avatars/1e91cf02-95a4-4982-839a-ad9d9735f7b5.jpg",
        smallPhoto: "/media/avatars/1e91cf02-95a4-4982-839a-ad9d9735f7b5-sm.jpg",
        info: "Phasellus leo dolor, tempus non, auctor et, hendrerit quis, nisi. Curabitur ligula sapien, tincidunt non, euismod vitae, posuere imperdiet, leo. Maecenas malesuada.",
        password: "$2a$10$q7732w6Rj3kZGhfDYSIXI.wFp.uwTSi2inB2rYHvm1iDIAf1J1eVq",
        created: new Date("2019-07-28T16:44:39.463Z"),
        contacts: {
            skype: "aly-dutta",
            facebook: "https://facebook.com/aly-dutta",
            stackoverflow: "https://stackoverflow.com/aly-dutta"
        },
        completed: true,
        certificates: [{
            name: "Jee certificate.jpg",
            largeUrl: "/media/certificates/ea8651ee-363a-4397-ab95-de1fd8db6ce1.jpg",
            smallUrl: "/media/certificates/ea8651ee-363a-4397-ab95-de1fd8db6ce1-sm.jpg"
        }],
        education: [{
            summary: "The specialist degree in Electronic Engineering",
            beginYear: 2006,
            finishYear: 2011,
            university: "Kharkiv National Technical University, Ukraine",
            faculty: "Computer Science"
        }],
        hobbies: [{name: "Movie"}, {name: "Disco"}, {name: "Swimming"}, {name: "Computer games"}, {name: "Archery"}],
        languages: [{name: "English", level: "PROFICIENCY", type: "WRITING"}, {
            name: "English",
            level: "PROFICIENCY",
            type: "SPOKEN"
        }],
        practics: [{
            position: "Java Advanced Course",
            company: "DevStudy.net",
            beginDate: new Date("2019-05-28T16:44:39.606Z"),
            finishDate: new Date("2019-06-28T16:44:39.606Z"),
            responsibilities: "Developing the web application 'online-resume' using bootstrap HTML template, downloaded from intenet. Populating database by test data and uploading web project to AWS EC2 instance",
            demo: "http://LINK_TO_DEMO_SITE",
            github: "https://github.com/TODO"
        }],
        skills: [{idCategory: 1, category: "Languages", value: "Java, SQL, PLSQL"}, {
            idCategory: 2,
            category: "DBMS",
            value: "Postgresql"
        }, {idCategory: 3, category: "Web", value: "HTML, CSS, JS, Bootstrap, JQuery"}, {
            idCategory: 4,
            category: "Java",
            value: "Spring MVC, Logback, JSP, JSTL, Spring Data JPA, Apache Commons, Spring Security, Hibernate JPA, Facebook Social API"
        }, {idCategory: 5, category: "IDE", value: "Eclipse for JEE Developer"}, {
            idCategory: 6,
            category: "CVS",
            value: "Git, Github"
        }, {idCategory: 7, category: "Web Servers", value: "Tomcat, Nginx"}, {
            idCategory: 8,
            category: "Build system",
            value: "Maven"
        }, {idCategory: 9, category: "Cloud", value: "AWS"}],
        courses: [{
            name: "Java Advanced Course",
            school: "SourceIt",
            finish_date: new Date("2011-06-30T16:44:39.176Z")
        }]
    }),
    db.profile.insert({
        uid: "amy-fowler",
        firstName: "Amy",
        lastName: "Fowler",
        birthDay: new Date("1992-08-24T16:44:39.650Z"),
        phone: "+380506263863",
        email: "amy-fowler@gmail.com",
        country: "Ukraine",
        city: "Odessa",
        objective: "Junior java developer position",
        summary: "Two Java professional courses with developing two web applications: blog and resume (Links to demo are provided)",
        largePhoto: "/media/avatars/ab75f2eb-22ad-495d-be0e-43754c96a065.jpg",
        smallPhoto: "/media/avatars/ab75f2eb-22ad-495d-be0e-43754c96a065-sm.jpg",
        password: "$2a$10$q7732w6Rj3kZGhfDYSIXI.wFp.uwTSi2inB2rYHvm1iDIAf1J1eVq",
        created: new Date("2019-07-28T16:44:39.664Z"),
        contacts: {
            vkontakte: "https://vk.com/amy-fowler",
            github: "https://github.com/amy-fowler",
            stackoverflow: "https://stackoverflow.com/amy-fowler"
        },
        completed: true,
        certificates: [{
            name: "Jee certificate.jpg",
            largeUrl: "/media/certificates/acdc5c4f-fdaa-46d8-865c-1063cf566835.jpg",
            smallUrl: "/media/certificates/acdc5c4f-fdaa-46d8-865c-1063cf566835-sm.jpg"
        }],
        education: [{
            summary: "The specialist degree in Electronic Engineering",
            beginYear: 2008,
            finishYear: 2013,
            university: "Kharkiv National Technical University, Ukraine",
            faculty: "Computer Science"
        }],
        hobbies: [{name: "Billiards"}, {name: "Camping"}, {name: "Volleyball"}, {name: "Traveling"}, {name: "Foreign lang"}],
        languages: [{name: "English", level: "PRE_INTERMEDIATE", type: "SPOKEN"}, {
            name: "English",
            level: "PRE_INTERMEDIATE",
            type: "WRITING"
        }, {name: "Spanish", level: "BEGINNER", type: "ALL"}],
        practics: [{
            position: "Java Advanced Course",
            company: "DevStudy.net",
            beginDate: new Date("2019-06-28T16:44:39.717Z"),
            responsibilities: "Developing the web application 'online-resume' using bootstrap HTML template, downloaded from intenet. Populating database by test data and uploading web project to AWS EC2 instance",
            demo: "http://LINK_TO_DEMO_SITE",
            github: "https://github.com/TODO"
        }, {
            position: "Java Base Course",
            company: "DevStudy.net",
            beginDate: new Date("2019-06-28T16:44:39.717Z"),
            responsibilities: "Developing the web application 'blog' using free HTML template, downloaded from intenet. Populating database by test data and uploading web project to OpenShift free hosting",
            demo: "http://LINK_TO_DEMO_SITE",
            github: "https://github.com/TODO"
        }],
        skills: [{idCategory: 1, category: "Languages", value: "Java, SQL, PLSQL"}, {
            idCategory: 2,
            category: "DBMS",
            value: "Postgresql"
        }, {idCategory: 3, category: "Web", value: "HTML, CSS, JS, Bootstrap, JQuery, Foundation"}, {
            idCategory: 4,
            category: "Java",
            value: "Spring MVC, Logback, JSP, JSTL, Spring Data JPA, Apache Commons, Spring Security, Hibernate JPA, Facebook Social API, Servlets, JDBC, Google+ Social API"
        }, {idCategory: 5, category: "IDE", value: "Eclipse for JEE Developer"}, {
            idCategory: 6,
            category: "CVS",
            value: "Git, Github"
        }, {idCategory: 7, category: "Web Servers", value: "Tomcat, Nginx"}, {
            idCategory: 8,
            category: "Build system",
            value: "Maven"
        }, {idCategory: 9, category: "Cloud", value: "AWS, OpenShift"}]
    }),
    db.profile.insert({
        uid: "bernadette-rostenkowski",
        firstName: "Bernadette",
        lastName: "Rostenkowski",
        birthDay: new Date("1996-10-05T16:44:39.720Z"),
        phone: "+380501731375",
        email: "bernadette-rostenkowski@gmail.com",
        country: "Ukraine",
        city: "Odessa",
        objective: "Junior java trainee position",
        summary: "Java core course with developing one simple console application",
        largePhoto: "/media/avatars/d33847e2-b5f4-42aa-96f8-bd1f2f420329.jpg",
        smallPhoto: "/media/avatars/d33847e2-b5f4-42aa-96f8-bd1f2f420329-sm.jpg",
        password: "$2a$10$q7732w6Rj3kZGhfDYSIXI.wFp.uwTSi2inB2rYHvm1iDIAf1J1eVq",
        created: new Date("2019-07-28T16:44:39.742Z"),
        contacts: {
            skype: "bernadette-rostenkowski",
            vkontakte: "https://vk.com/bernadette-rostenkowski",
            linkedin: "https://linkedin.com/bernadette-rostenkowski"
        },
        completed: true,
        education: [{
            summary: "The specialist degree in Electronic Engineering",
            beginYear: 2012,
            finishYear: 2017,
            university: "Kharkiv National Technical University, Ukraine",
            faculty: "Computer Science"
        }],
        hobbies: [{name: "Photo"}, {name: "Shopping"}, {name: "Automobiles"}, {name: "Table tennis"}, {name: "Badminton"}],
        languages: [{name: "English", level: "INTERMEDIATE", type: "SPOKEN"}, {
            name: "English",
            level: "INTERMEDIATE",
            type: "WRITING"
        }],
        practics: [{
            position: "Java Core Course",
            company: "DevStudy.net",
            beginDate: new Date("2019-03-28T17:44:39.743Z"),
            finishDate: new Date("2019-04-28T16:44:39.743Z"),
            responsibilities: "Developing the java console application which imports XML, JSON, Properties, CVS to Db via JDBC",
            demo: null,
            github: null
        }],
        skills: [{idCategory: 1, category: "Languages", value: "Java"}, {
            idCategory: 2,
            category: "DBMS",
            value: "Mysql"
        }, {idCategory: 4, category: "Java", value: "Threads, IO, JAXB, GSON"}, {
            idCategory: 5,
            category: "IDE",
            value: "Eclipse for JEE Developer"
        }, {idCategory: 6, category: "CVS", value: "Git, Github"}, {
            idCategory: 8,
            category: "Build system",
            value: "Maven"
        }],
        courses: [{
            name: "Java Advanced Course",
            school: "SourceIt",
            finish_date: new Date("2017-06-30T16:44:39.720Z")
        }]
    }),
    db.profile.insert({
        uid: "bertram-gilfoyle",
        firstName: "Bertram",
        lastName: "Gilfoyle",
        birthDay: new Date("1990-02-27T16:44:39.745Z"),
        phone: "+380509561528",
        email: "bertram-gilfoyle@gmail.com",
        country: "Ukraine",
        city: "Odessa",
        objective: "Junior java trainee position",
        summary: "One Java professional course with developing web application blog (Link to demo is provided)",
        largePhoto: "/media/avatars/fab82e96-5a51-4b93-9a93-46879d8da1aa.jpg",
        smallPhoto: "/media/avatars/fab82e96-5a51-4b93-9a93-46879d8da1aa-sm.jpg",
        info: "Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo.",
        password: "$2a$10$q7732w6Rj3kZGhfDYSIXI.wFp.uwTSi2inB2rYHvm1iDIAf1J1eVq",
        created: new Date("2019-07-28T16:44:39.797Z"),
        contacts: {},
        completed: true,
        education: [{
            summary: "The specialist degree in Electronic Engineering",
            beginYear: 2006,
            finishYear: 2011,
            university: "Kharkiv National Technical University, Ukraine",
            faculty: "Computer Science"
        }],
        hobbies: [{name: "Badminton"}, {name: "Baseball"}, {name: "Cricket"}, {name: "Rowing"}, {name: "Fishing"}],
        languages: [{name: "English", level: "ELEMENTARY", type: "WRITING"}, {
            name: "English",
            level: "ELEMENTARY",
            type: "SPOKEN"
        }, {name: "Italian", level: "PROFICIENCY", type: "WRITING"}, {
            name: "Italian",
            level: "PROFICIENCY",
            type: "SPOKEN"
        }],
        practics: [{
            position: "Java Base Course",
            company: "DevStudy.net",
            beginDate: new Date("2019-06-28T16:44:39.799Z"),
            responsibilities: "Developing the web application 'blog' using free HTML template, downloaded from intenet. Populating database by test data and uploading web project to OpenShift free hosting",
            demo: "http://LINK_TO_DEMO_SITE",
            github: "https://github.com/TODO"
        }],
        skills: [{idCategory: 1, category: "Languages", value: "Java, SQL"}, {
            idCategory: 2,
            category: "DBMS",
            value: "Postgresql"
        }, {idCategory: 3, category: "Web", value: "HTML, CSS, JS, Foundation, JQuery"}, {
            idCategory: 4,
            category: "Java",
            value: "Servlets, Logback, JSP, JSTL, JDBC, Apache Commons, Google+ Social API"
        }, {idCategory: 5, category: "IDE", value: "Eclipse for JEE Developer"}, {
            idCategory: 6,
            category: "CVS",
            value: "Git, Github"
        }, {idCategory: 7, category: "Web Servers", value: "Tomcat"}, {
            idCategory: 8,
            category: "Build system",
            value: "Maven"
        }, {idCategory: 9, category: "Cloud", value: "OpenShift"}],
        courses: [{
            name: "Java Advanced Course",
            school: "SourceIt",
            finish_date: new Date("2012-06-30T16:44:39.745Z")
        }]
    }),
    db.profile.insert({
        uid: "carla-walton",
        firstName: "Carla",
        lastName: "Walton",
        birthDay: new Date("1990-06-09T15:44:39.803Z"),
        phone: "+380501942219",
        email: "carla-walton@gmail.com",
        country: "Ukraine",
        city: "Kiyv",
        objective: "Junior java developer position",
        summary: "Two Java professional courses with developing two web applications: blog and resume (Links to demo are provided)",
        largePhoto: "/media/avatars/0284e3a5-b50e-4f36-8b73-8afbebd41a8a.jpg",
        smallPhoto: "/media/avatars/0284e3a5-b50e-4f36-8b73-8afbebd41a8a-sm.jpg",
        password: "$2a$10$q7732w6Rj3kZGhfDYSIXI.wFp.uwTSi2inB2rYHvm1iDIAf1J1eVq",
        created: new Date("2019-07-28T16:44:39.839Z"),
        contacts: {skype: "carla-walton"},
        completed: true,
        certificates: [{
            name: "Jee certificate.jpg",
            largeUrl: "/media/certificates/65aca1dd-19b6-4b37-8b4e-af6dd5c52089.jpg",
            smallUrl: "/media/certificates/65aca1dd-19b6-4b37-8b4e-af6dd5c52089-sm.jpg"
        }],
        education: [{
            summary: "The specialist degree in Electronic Engineering",
            beginYear: 2006,
            finishYear: 2011,
            university: "Kharkiv National Technical University, Ukraine",
            faculty: "Computer Science"
        }],
        hobbies: [{name: "Automobiles"}, {name: "Games of chance"}, {name: "Boxing"}, {name: "Authorship"}, {name: "Archery"}],
        languages: [{name: "English", level: "PRE_INTERMEDIATE", type: "SPOKEN"}, {
            name: "English",
            level: "PRE_INTERMEDIATE",
            type: "WRITING"
        }, {name: "French", level: "PROFICIENCY", type: "SPOKEN"}, {
            name: "French",
            level: "PROFICIENCY",
            type: "WRITING"
        }],
        practics: [{
            position: "Java Advanced Course",
            company: "DevStudy.net",
            beginDate: new Date("2019-06-28T16:44:39.888Z"),
            responsibilities: "Developing the web application 'online-resume' using bootstrap HTML template, downloaded from intenet. Populating database by test data and uploading web project to AWS EC2 instance",
            demo: "http://LINK_TO_DEMO_SITE",
            github: "https://github.com/TODO"
        }, {
            position: "Java Base Course",
            company: "DevStudy.net",
            beginDate: new Date("2019-06-28T16:44:39.888Z"),
            responsibilities: "Developing the web application 'blog' using free HTML template, downloaded from intenet. Populating database by test data and uploading web project to OpenShift free hosting",
            demo: "http://LINK_TO_DEMO_SITE",
            github: "https://github.com/TODO"
        }],
        skills: [{idCategory: 1, category: "Languages", value: "Java, SQL, PLSQL"}, {
            idCategory: 2,
            category: "DBMS",
            value: "Postgresql"
        }, {idCategory: 3, category: "Web", value: "HTML, CSS, JS, Bootstrap, JQuery, Foundation"}, {
            idCategory: 4,
            category: "Java",
            value: "Spring MVC, Logback, JSP, JSTL, Spring Data JPA, Apache Commons, Spring Security, Hibernate JPA, Facebook Social API, Servlets, JDBC, Google+ Social API"
        }, {idCategory: 5, category: "IDE", value: "Eclipse for JEE Developer"}, {
            idCategory: 6,
            category: "CVS",
            value: "Git, Github"
        }, {idCategory: 7, category: "Web Servers", value: "Tomcat, Nginx"}, {
            idCategory: 8,
            category: "Build system",
            value: "Maven"
        }, {idCategory: 9, category: "Cloud", value: "AWS, OpenShift"}],
        courses: [{
            name: "Java Advanced Course",
            school: "SourceIt",
            finish_date: new Date("2011-06-30T16:44:39.803Z")
        }]
    }),
    db.profile.insert({
        uid: "dinesh-chugtai",
        firstName: "Dinesh",
        lastName: "Chugtai",
        birthDay: new Date("1996-12-07T17:44:39.891Z"),
        phone: "+380504427168",
        email: "dinesh-chugtai@gmail.com",
        country: "Ukraine",
        city: "Odessa",
        objective: "Junior java developer position",
        summary: "One Java professional course with developing web application resume (Link to demo is provided)",
        largePhoto: "/media/avatars/c46f9a9a-3889-4a99-b1f6-bf2fd1d9d7e9.jpg",
        smallPhoto: "/media/avatars/c46f9a9a-3889-4a99-b1f6-bf2fd1d9d7e9-sm.jpg",
        info: "Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi.",
        password: "$2a$10$q7732w6Rj3kZGhfDYSIXI.wFp.uwTSi2inB2rYHvm1iDIAf1J1eVq",
        created: new Date("2019-07-28T16:44:39.917Z"),
        contacts: {
            vkontakte: "https://vk.com/dinesh-chugtai",
            facebook: "https://facebook.com/dinesh-chugtai",
            linkedin: "https://linkedin.com/dinesh-chugtai",
            stackoverflow: "https://stackoverflow.com/dinesh-chugtai"
        },
        completed: true,
        certificates: [{
            name: "Jee certificate.jpg",
            largeUrl: "/media/certificates/51092ff0-de19-4820-b214-769619fd6511.jpg",
            smallUrl: "/media/certificates/51092ff0-de19-4820-b214-769619fd6511-sm.jpg"
        }],
        education: [{
            summary: "The specialist degree in Electronic Engineering",
            beginYear: 2014,
            finishYear: 2019,
            university: "Kharkiv National Technical University, Ukraine",
            faculty: "Computer Science"
        }],
        hobbies: [{name: "Ice hockey"}, {name: "Bowling"}, {name: "Kayak slalom"}, {name: "Diving"}, {name: "Darts"}],
        languages: [{name: "English", level: "PRE_INTERMEDIATE", type: "WRITING"}, {
            name: "English",
            level: "PRE_INTERMEDIATE",
            type: "SPOKEN"
        }, {name: "German", level: "PROFICIENCY", type: "SPOKEN"}, {
            name: "German",
            level: "PROFICIENCY",
            type: "WRITING"
        }],
        practics: [{
            position: "Java Advanced Course",
            company: "DevStudy.net",
            beginDate: new Date("2019-06-28T16:44:39.954Z"),
            responsibilities: "Developing the web application 'online-resume' using bootstrap HTML template, downloaded from intenet. Populating database by test data and uploading web project to AWS EC2 instance",
            demo: "http://LINK_TO_DEMO_SITE",
            github: "https://github.com/TODO"
        }],
        skills: [{idCategory: 1, category: "Languages", value: "Java, SQL, PLSQL"}, {
            idCategory: 2,
            category: "DBMS",
            value: "Postgresql"
        }, {idCategory: 3, category: "Web", value: "HTML, CSS, JS, Bootstrap, JQuery"}, {
            idCategory: 4,
            category: "Java",
            value: "Spring MVC, Logback, JSP, JSTL, Spring Data JPA, Apache Commons, Spring Security, Hibernate JPA, Facebook Social API"
        }, {idCategory: 5, category: "IDE", value: "Eclipse for JEE Developer"}, {
            idCategory: 6,
            category: "CVS",
            value: "Git, Github"
        }, {idCategory: 7, category: "Web Servers", value: "Tomcat, Nginx"}, {
            idCategory: 8,
            category: "Build system",
            value: "Maven"
        }, {idCategory: 9, category: "Cloud", value: "AWS"}]
    }),
    db.profile.insert({
        uid: "erlich-bachmann",
        firstName: "Erlich",
        lastName: "Bachmann",
        birthDay: new Date("1995-06-21T16:44:39.957Z"),
        phone: "+380505536689",
        email: "erlich-bachmann@gmail.com",
        country: "Ukraine",
        city: "Odessa",
        objective: "Junior java developer position",
        summary: "Three Java professional courses with developing one console application and two web applications: blog and resume (Links to demo are provided)",
        largePhoto: "/media/avatars/9f57b5c0-3b02-43c4-8d0f-c98f54726eb6.jpg",
        smallPhoto: "/media/avatars/9f57b5c0-3b02-43c4-8d0f-c98f54726eb6-sm.jpg",
        password: "$2a$10$q7732w6Rj3kZGhfDYSIXI.wFp.uwTSi2inB2rYHvm1iDIAf1J1eVq",
        created: new Date("2019-07-28T16:44:39.968Z"),
        contacts: {
            facebook: "https://facebook.com/erlich-bachmann",
            linkedin: "https://linkedin.com/erlich-bachmann",
            stackoverflow: "https://stackoverflow.com/erlich-bachmann"
        },
        completed: true,
        certificates: [{
            name: "Jee certificate.jpg",
            largeUrl: "/media/certificates/20a75e6f-e90d-48e3-90f4-0aed0210c9a4.jpg",
            smallUrl: "/media/certificates/20a75e6f-e90d-48e3-90f4-0aed0210c9a4-sm.jpg"
        }, {
            name: "Mongo certificate.jpg",
            largeUrl: "/media/certificates/57db2148-58fe-41a8-b0c7-0c2d0d59a8f3.jpg",
            smallUrl: "/media/certificates/57db2148-58fe-41a8-b0c7-0c2d0d59a8f3-sm.jpg"
        }],
        education: [{
            summary: "The specialist degree in Electronic Engineering",
            beginYear: 2011,
            finishYear: 2016,
            university: "Kharkiv National Technical University, Ukraine",
            faculty: "Computer Science"
        }],
        hobbies: [{name: "Fishing"}, {name: "Games of chance"}, {name: "Automobiles"}, {name: "Authorship"}, {name: "Collecting"}],
        languages: [{name: "English", level: "UPPER_INTERMEDIATE", type: "SPOKEN"}, {
            name: "English",
            level: "UPPER_INTERMEDIATE",
            type: "WRITING"
        }],
        practics: [{
            position: "Java Advanced Course",
            company: "DevStudy.net",
            beginDate: new Date("2019-03-28T17:44:40.053Z"),
            finishDate: new Date("2019-04-28T16:44:40.053Z"),
            responsibilities: "Developing the web application 'online-resume' using bootstrap HTML template, downloaded from intenet. Populating database by test data and uploading web project to AWS EC2 instance",
            demo: "http://LINK_TO_DEMO_SITE",
            github: "https://github.com/TODO"
        }, {
            position: "Java Base Course",
            company: "DevStudy.net",
            beginDate: new Date("2019-02-28T17:44:40.053Z"),
            finishDate: new Date("2019-03-28T17:44:40.053Z"),
            responsibilities: "Developing the web application 'blog' using free HTML template, downloaded from intenet. Populating database by test data and uploading web project to OpenShift free hosting",
            demo: "http://LINK_TO_DEMO_SITE",
            github: "https://github.com/TODO"
        }, {
            position: "Java Core Course",
            company: "DevStudy.net",
            beginDate: new Date("2018-12-28T17:44:40.053Z"),
            finishDate: new Date("2019-01-28T17:44:40.053Z"),
            responsibilities: "Developing the java console application which imports XML, JSON, Properties, CVS to Db via JDBC",
            demo: null,
            github: null
        }],
        skills: [{idCategory: 1, category: "Languages", value: "Java, SQL, PLSQL"}, {
            idCategory: 2,
            category: "DBMS",
            value: "Postgresql, Mysql"
        }, {idCategory: 3, category: "Web", value: "HTML, CSS, JS, Bootstrap, JQuery, Foundation"}, {
            idCategory: 4,
            category: "Java",
            value: "Spring MVC, Logback, JSP, JSTL, Spring Data JPA, Apache Commons, Spring Security, Hibernate JPA, Facebook Social API, Servlets, JDBC, Google+ Social API, Threads, IO, JAXB, GSON"
        }, {idCategory: 5, category: "IDE", value: "Eclipse for JEE Developer"}, {
            idCategory: 6,
            category: "CVS",
            value: "Git, Github"
        }, {idCategory: 7, category: "Web Servers", value: "Tomcat, Nginx"}, {
            idCategory: 8,
            category: "Build system",
            value: "Maven"
        }, {idCategory: 9, category: "Cloud", value: "AWS, OpenShift"}]
    }),
    db.profile.insert({
        uid: "harold-gunderson",
        firstName: "Harold",
        lastName: "Gunderson",
        birthDay: new Date("1990-02-08T16:44:40.055Z"),
        phone: "+380509931325",
        email: "harold-gunderson@gmail.com",
        country: "Ukraine",
        city: "Odessa",
        objective: "Junior java developer position",
        summary: "Two Java professional courses with developing two web applications: blog and resume (Links to demo are provided)",
        largePhoto: "/media/avatars/2c7cac89-31e0-47bb-805f-e2336b7b6346.jpg",
        smallPhoto: "/media/avatars/2c7cac89-31e0-47bb-805f-e2336b7b6346-sm.jpg",
        info: "Nullam vel sem. Pellentesque libero tortor, tincidunt et, tincidunt eget, semper nec, quam. Sed hendrerit.",
        password: "$2a$10$q7732w6Rj3kZGhfDYSIXI.wFp.uwTSi2inB2rYHvm1iDIAf1J1eVq",
        created: new Date("2019-07-28T16:44:40.062Z"),
        contacts: {
            vkontakte: "https://vk.com/harold-gunderson",
            linkedin: "https://linkedin.com/harold-gunderson",
            github: "https://github.com/harold-gunderson",
            stackoverflow: "https://stackoverflow.com/harold-gunderson"
        },
        completed: true,
        certificates: [{
            name: "Mongo certificate.jpg",
            largeUrl: "/media/certificates/947885fa-95c5-444a-8e2b-00f143612cfa.jpg",
            smallUrl: "/media/certificates/947885fa-95c5-444a-8e2b-00f143612cfa-sm.jpg"
        }, {
            name: "Jee certificate.jpg",
            largeUrl: "/media/certificates/c90d720f-8fac-4014-af5c-cc2d29dd790c.jpg",
            smallUrl: "/media/certificates/c90d720f-8fac-4014-af5c-cc2d29dd790c-sm.jpg"
        }],
        education: [{
            summary: "The specialist degree in Electronic Engineering",
            beginYear: 2008,
            finishYear: 2013,
            university: "Kharkiv National Technical University, Ukraine",
            faculty: "Computer Science"
        }],
        hobbies: [{name: "Baseball"}, {name: "Games of chance"}, {name: "Photo"}, {name: "Badminton"}, {name: "Authorship"}],
        languages: [{name: "English", level: "ELEMENTARY", type: "ALL"}],
        practics: [{
            position: "Java Advanced Course",
            company: "DevStudy.net",
            beginDate: new Date("2019-04-28T16:44:40.157Z"),
            finishDate: new Date("2019-05-28T16:44:40.157Z"),
            responsibilities: "Developing the web application 'online-resume' using bootstrap HTML template, downloaded from intenet. Populating database by test data and uploading web project to AWS EC2 instance",
            demo: "http://LINK_TO_DEMO_SITE",
            github: "https://github.com/TODO"
        }, {
            position: "Java Base Course",
            company: "DevStudy.net",
            beginDate: new Date("2019-03-28T17:44:40.157Z"),
            finishDate: new Date("2019-04-28T16:44:40.157Z"),
            responsibilities: "Developing the web application 'blog' using free HTML template, downloaded from intenet. Populating database by test data and uploading web project to OpenShift free hosting",
            demo: "http://LINK_TO_DEMO_SITE",
            github: "https://github.com/TODO"
        }],
        skills: [{idCategory: 1, category: "Languages", value: "Java, SQL, PLSQL"}, {
            idCategory: 2,
            category: "DBMS",
            value: "Postgresql"
        }, {idCategory: 3, category: "Web", value: "HTML, CSS, JS, Bootstrap, JQuery, Foundation"}, {
            idCategory: 4,
            category: "Java",
            value: "Spring MVC, Logback, JSP, JSTL, Spring Data JPA, Apache Commons, Spring Security, Hibernate JPA, Facebook Social API, Servlets, JDBC, Google+ Social API"
        }, {idCategory: 5, category: "IDE", value: "Eclipse for JEE Developer"}, {
            idCategory: 6,
            category: "CVS",
            value: "Git, Github"
        }, {idCategory: 7, category: "Web Servers", value: "Tomcat, Nginx"}, {
            idCategory: 8,
            category: "Build system",
            value: "Maven"
        }, {idCategory: 9, category: "Cloud", value: "AWS, OpenShift"}],
        courses: [{
            name: "Java Advanced Course",
            school: "SourceIt",
            finish_date: new Date("2011-06-30T16:44:40.055Z")
        }]
    }),
    db.profile.insert({
        uid: "howard-wolowitz",
        firstName: "Howard",
        lastName: "Wolowitz",
        birthDay: new Date("1993-04-30T16:44:40.159Z"),
        phone: "+380508252781",
        email: "howard-wolowitz@gmail.com",
        country: "Ukraine",
        city: "Kharkiv",
        objective: "Junior java trainee position",
        summary: "Java core course with developing one simple console application",
        largePhoto: "/media/avatars/6536f8b6-4080-4748-ab3d-ae1475ec82f7.jpg",
        smallPhoto: "/media/avatars/6536f8b6-4080-4748-ab3d-ae1475ec82f7-sm.jpg",
        info: "In auctor lobortis lacus. Quisque libero metus, condimentum nec, tempor a, commodo mollis, magna. Vestibulum ullamcorper mauris at ligula.",
        password: "$2a$10$q7732w6Rj3kZGhfDYSIXI.wFp.uwTSi2inB2rYHvm1iDIAf1J1eVq",
        created: new Date("2019-07-28T16:44:40.175Z"),
        contacts: {skype: "howard-wolowitz", facebook: "https://facebook.com/howard-wolowitz"},
        completed: true,
        education: [{
            summary: "The specialist degree in Electronic Engineering",
            beginYear: 2010,
            finishYear: 2015,
            university: "Kharkiv National Technical University, Ukraine",
            faculty: "Computer Science"
        }],
        hobbies: [{name: "Shopping"}, {name: "Kayak slalom"}, {name: "Photo"}, {name: "Foreign lang"}, {name: "Rowing"}],
        languages: [{name: "English", level: "UPPER_INTERMEDIATE", type: "SPOKEN"}, {
            name: "English",
            level: "UPPER_INTERMEDIATE",
            type: "WRITING"
        }, {name: "French", level: "UPPER_INTERMEDIATE", type: "SPOKEN"}, {
            name: "French",
            level: "UPPER_INTERMEDIATE",
            type: "WRITING"
        }],
        practics: [{
            position: "Java Core Course",
            company: "DevStudy.net",
            beginDate: new Date("2019-06-28T16:44:40.175Z"),
            responsibilities: "Developing the java console application which imports XML, JSON, Properties, CVS to Db via JDBC",
            demo: null,
            github: null
        }],
        skills: [{idCategory: 1, category: "Languages", value: "Java"}, {
            idCategory: 2,
            category: "DBMS",
            value: "Mysql"
        }, {idCategory: 4, category: "Java", value: "Threads, IO, JAXB, GSON"}, {
            idCategory: 5,
            category: "IDE",
            value: "Eclipse for JEE Developer"
        }, {idCategory: 6, category: "CVS", value: "Git, Github"}, {
            idCategory: 8,
            category: "Build system",
            value: "Maven"
        }]
    }),
    db.profile.insert({
        uid: "jared-dunn",
        firstName: "Jared",
        lastName: "Dunn",
        birthDay: new Date("1994-07-16T16:44:40.177Z"),
        phone: "+380506596778",
        email: "jared-dunn@gmail.com",
        country: "Ukraine",
        city: "Odessa",
        objective: "Junior java developer position",
        summary: "Two Java professional courses with developing two web applications: blog and resume (Links to demo are provided)",
        largePhoto: "/media/avatars/7e4989de-59c6-4891-b0ba-579eeb2d6d8a.jpg",
        smallPhoto: "/media/avatars/7e4989de-59c6-4891-b0ba-579eeb2d6d8a-sm.jpg",
        password: "$2a$10$q7732w6Rj3kZGhfDYSIXI.wFp.uwTSi2inB2rYHvm1iDIAf1J1eVq",
        created: new Date("2019-07-28T16:44:40.187Z"),
        contacts: {
            skype: "jared-dunn",
            vkontakte: "https://vk.com/jared-dunn",
            github: "https://github.com/jared-dunn",
            stackoverflow: "https://stackoverflow.com/jared-dunn"
        },
        completed: true,
        certificates: [{
            name: "Jee certificate.jpg",
            largeUrl: "/media/certificates/68bf0747-3e88-4397-a9b6-8f180cfa7228.jpg",
            smallUrl: "/media/certificates/68bf0747-3e88-4397-a9b6-8f180cfa7228-sm.jpg"
        }, {
            name: "Mongo certificate.jpg",
            largeUrl: "/media/certificates/abbc11a3-8052-48e3-9265-48bfd0242c0b.jpg",
            smallUrl: "/media/certificates/abbc11a3-8052-48e3-9265-48bfd0242c0b-sm.jpg"
        }],
        education: [{
            summary: "The specialist degree in Electronic Engineering",
            beginYear: 2010,
            finishYear: 2015,
            university: "Kharkiv National Technical University, Ukraine",
            faculty: "Computer Science"
        }],
        hobbies: [{name: "Football"}, {name: "Automobiles"}, {name: "Book reading"}, {name: "Pubs"}, {name: "Computer games"}],
        languages: [{name: "English", level: "INTERMEDIATE", type: "WRITING"}, {
            name: "English",
            level: "INTERMEDIATE",
            type: "SPOKEN"
        }, {name: "Italian", level: "BEGINNER", type: "SPOKEN"}, {
            name: "Italian",
            level: "BEGINNER",
            type: "WRITING"
        }],
        practics: [{
            position: "Java Advanced Course",
            company: "DevStudy.net",
            beginDate: new Date("2019-06-28T16:44:40.266Z"),
            responsibilities: "Developing the web application 'online-resume' using bootstrap HTML template, downloaded from intenet. Populating database by test data and uploading web project to AWS EC2 instance",
            demo: "http://LINK_TO_DEMO_SITE",
            github: "https://github.com/TODO"
        }, {
            position: "Java Base Course",
            company: "DevStudy.net",
            beginDate: new Date("2019-06-28T16:44:40.266Z"),
            responsibilities: "Developing the web application 'blog' using free HTML template, downloaded from intenet. Populating database by test data and uploading web project to OpenShift free hosting",
            demo: "http://LINK_TO_DEMO_SITE",
            github: "https://github.com/TODO"
        }],
        skills: [{idCategory: 1, category: "Languages", value: "Java, SQL, PLSQL"}, {
            idCategory: 2,
            category: "DBMS",
            value: "Postgresql"
        }, {idCategory: 3, category: "Web", value: "HTML, CSS, JS, Bootstrap, JQuery, Foundation"}, {
            idCategory: 4,
            category: "Java",
            value: "Spring MVC, Logback, JSP, JSTL, Spring Data JPA, Apache Commons, Spring Security, Hibernate JPA, Facebook Social API, Servlets, JDBC, Google+ Social API"
        }, {idCategory: 5, category: "IDE", value: "Eclipse for JEE Developer"}, {
            idCategory: 6,
            category: "CVS",
            value: "Git, Github"
        }, {idCategory: 7, category: "Web Servers", value: "Tomcat, Nginx"}, {
            idCategory: 8,
            category: "Build system",
            value: "Maven"
        }, {idCategory: 9, category: "Cloud", value: "AWS, OpenShift"}],
        courses: [{
            name: "Java Advanced Course",
            school: "SourceIt",
            finish_date: new Date("2015-06-30T16:44:40.177Z")
        }]
    }),
    db.profile.insert({
        uid: "jen-barber",
        firstName: "Jen",
        lastName: "Barber",
        birthDay: new Date("1998-08-24T16:44:40.268Z"),
        phone: "+380507646823",
        email: "jen-barber@gmail.com",
        country: "Ukraine",
        city: "Kiyv",
        objective: "Junior java developer position",
        summary: "Two Java professional courses with developing two web applications: blog and resume (Links to demo are provided)",
        largePhoto: "/media/avatars/997043d3-e9ee-4947-9fa0-d11014c30fa6.jpg",
        smallPhoto: "/media/avatars/997043d3-e9ee-4947-9fa0-d11014c30fa6-sm.jpg",
        info: "Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium.",
        password: "$2a$10$q7732w6Rj3kZGhfDYSIXI.wFp.uwTSi2inB2rYHvm1iDIAf1J1eVq",
        created: new Date("2019-07-28T16:44:40.278Z"),
        contacts: {vkontakte: "https://vk.com/jen-barber", facebook: "https://facebook.com/jen-barber"},
        completed: true,
        certificates: [{
            name: "Jee certificate.jpg",
            largeUrl: "/media/certificates/c8ab2cc8-0d40-432e-b301-9eb5db1544a2.jpg",
            smallUrl: "/media/certificates/c8ab2cc8-0d40-432e-b301-9eb5db1544a2-sm.jpg"
        }],
        education: [{
            summary: "The specialist degree in Electronic Engineering",
            beginYear: 2014,
            finishYear: 2019,
            university: "Kharkiv National Technical University, Ukraine",
            faculty: "Computer Science"
        }],
        hobbies: [{name: "Darts"}, {name: "Cricket"}, {name: "Automobiles"}, {name: "Kayak slalom"}, {name: "Painting"}],
        languages: [{name: "English", level: "ELEMENTARY", type: "SPOKEN"}, {
            name: "English",
            level: "ELEMENTARY",
            type: "WRITING"
        }],
        practics: [{
            position: "Java Advanced Course",
            company: "DevStudy.net",
            beginDate: new Date("2019-06-28T16:44:40.327Z"),
            responsibilities: "Developing the web application 'online-resume' using bootstrap HTML template, downloaded from intenet. Populating database by test data and uploading web project to AWS EC2 instance",
            demo: "http://LINK_TO_DEMO_SITE",
            github: "https://github.com/TODO"
        }, {
            position: "Java Base Course",
            company: "DevStudy.net",
            beginDate: new Date("2019-06-28T16:44:40.327Z"),
            responsibilities: "Developing the web application 'blog' using free HTML template, downloaded from intenet. Populating database by test data and uploading web project to OpenShift free hosting",
            demo: "http://LINK_TO_DEMO_SITE",
            github: "https://github.com/TODO"
        }],
        skills: [{idCategory: 1, category: "Languages", value: "Java, SQL, PLSQL"}, {
            idCategory: 2,
            category: "DBMS",
            value: "Postgresql"
        }, {idCategory: 3, category: "Web", value: "HTML, CSS, JS, Bootstrap, JQuery, Foundation"}, {
            idCategory: 4,
            category: "Java",
            value: "Spring MVC, Logback, JSP, JSTL, Spring Data JPA, Apache Commons, Spring Security, Hibernate JPA, Facebook Social API, Servlets, JDBC, Google+ Social API"
        }, {idCategory: 5, category: "IDE", value: "Eclipse for JEE Developer"}, {
            idCategory: 6,
            category: "CVS",
            value: "Git, Github"
        }, {idCategory: 7, category: "Web Servers", value: "Tomcat, Nginx"}, {
            idCategory: 8,
            category: "Build system",
            value: "Maven"
        }, {idCategory: 9, category: "Cloud", value: "AWS, OpenShift"}],
        courses: [{name: "Java Advanced Course", school: "SourceIt"}]
    }),
    db.profile.insert({
        uid: "katrina-bennett",
        firstName: "Katrina",
        lastName: "Bennett",
        birthDay: new Date("1991-09-21T16:44:40.331Z"),
        phone: "+380502749852",
        email: "katrina-bennett@gmail.com",
        country: "Ukraine",
        city: "Kharkiv",
        objective: "Junior java developer position",
        summary: "Three Java professional courses with developing one console application and two web applications: blog and resume (Links to demo are provided)",
        largePhoto: "/media/avatars/aaeda4f9-716b-4f4a-bcd8-42311691e974.jpg",
        smallPhoto: "/media/avatars/aaeda4f9-716b-4f4a-bcd8-42311691e974-sm.jpg",
        info: "Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla mauris sit amet nibh.",
        password: "$2a$10$q7732w6Rj3kZGhfDYSIXI.wFp.uwTSi2inB2rYHvm1iDIAf1J1eVq",
        created: new Date("2019-07-28T16:44:40.355Z"),
        contacts: {linkedin: "https://linkedin.com/katrina-bennett"},
        completed: true,
        certificates: [{
            name: "Jee certificate.jpg",
            largeUrl: "/media/certificates/e68750a2-74da-4b21-8763-15d1e502b000.jpg",
            smallUrl: "/media/certificates/e68750a2-74da-4b21-8763-15d1e502b000-sm.jpg"
        }, {
            name: "Mongo certificate.jpg",
            largeUrl: "/media/certificates/704bd387-b388-47d3-8b9b-ebcb726b4328.jpg",
            smallUrl: "/media/certificates/704bd387-b388-47d3-8b9b-ebcb726b4328-sm.jpg"
        }],
        education: [{
            summary: "The specialist degree in Electronic Engineering",
            beginYear: 2009,
            finishYear: 2014,
            university: "Kharkiv National Technical University, Ukraine",
            faculty: "Computer Science"
        }],
        hobbies: [{name: "Fishing"}, {name: "Billiards"}, {name: "Computer games"}, {name: "Pubs"}, {name: "Animals"}],
        languages: [{name: "English", level: "ELEMENTARY", type: "SPOKEN"}, {
            name: "English",
            level: "ELEMENTARY",
            type: "WRITING"
        }, {name: "Italian", level: "ELEMENTARY", type: "ALL"}],
        practics: [{
            position: "Java Advanced Course",
            company: "DevStudy.net",
            beginDate: new Date("2019-03-28T17:44:40.445Z"),
            finishDate: new Date("2019-04-28T16:44:40.445Z"),
            responsibilities: "Developing the web application 'online-resume' using bootstrap HTML template, downloaded from intenet. Populating database by test data and uploading web project to AWS EC2 instance",
            demo: "http://LINK_TO_DEMO_SITE",
            github: "https://github.com/TODO"
        }, {
            position: "Java Base Course",
            company: "DevStudy.net",
            beginDate: new Date("2018-12-28T17:44:40.445Z"),
            finishDate: new Date("2019-01-28T17:44:40.445Z"),
            responsibilities: "Developing the web application 'blog' using free HTML template, downloaded from intenet. Populating database by test data and uploading web project to OpenShift free hosting",
            demo: "http://LINK_TO_DEMO_SITE",
            github: "https://github.com/TODO"
        }, {
            position: "Java Core Course",
            company: "DevStudy.net",
            beginDate: new Date("2018-10-28T17:44:40.445Z"),
            finishDate: new Date("2018-11-28T17:44:40.445Z"),
            responsibilities: "Developing the java console application which imports XML, JSON, Properties, CVS to Db via JDBC",
            demo: null,
            github: null
        }],
        skills: [{idCategory: 1, category: "Languages", value: "Java, SQL, PLSQL"}, {
            idCategory: 2,
            category: "DBMS",
            value: "Postgresql, Mysql"
        }, {idCategory: 3, category: "Web", value: "HTML, CSS, JS, Bootstrap, JQuery, Foundation"}, {
            idCategory: 4,
            category: "Java",
            value: "Spring MVC, Logback, JSP, JSTL, Spring Data JPA, Apache Commons, Spring Security, Hibernate JPA, Facebook Social API, Servlets, JDBC, Google+ Social API, Threads, IO, JAXB, GSON"
        }, {idCategory: 5, category: "IDE", value: "Eclipse for JEE Developer"}, {
            idCategory: 6,
            category: "CVS",
            value: "Git, Github"
        }, {idCategory: 7, category: "Web Servers", value: "Tomcat, Nginx"}, {
            idCategory: 8,
            category: "Build system",
            value: "Maven"
        }, {idCategory: 9, category: "Cloud", value: "AWS, OpenShift"}]
    }),
    db.profile.insert({
        uid: "leonard-hofstadter",
        firstName: "Leonard",
        lastName: "Hofstadter",
        birthDay: new Date("1989-07-24T15:44:40.450Z"),
        phone: "+380509121753",
        email: "leonard-hofstadter@gmail.com",
        country: "Ukraine",
        city: "Kiyv",
        objective: "Junior java developer position",
        summary: "Two Java professional courses with developing two web applications: blog and resume (Links to demo are provided)",
        largePhoto: "/media/avatars/e29116ad-8ab5-4d5c-a194-57cf03596580.jpg",
        smallPhoto: "/media/avatars/e29116ad-8ab5-4d5c-a194-57cf03596580-sm.jpg",
        info: "Nullam cursus lacinia erat. Praesent blandit laoreet nibh. Fusce convallis metus id felis luctus adipiscing.",
        password: "$2a$10$q7732w6Rj3kZGhfDYSIXI.wFp.uwTSi2inB2rYHvm1iDIAf1J1eVq",
        created: new Date("2019-07-28T16:44:40.462Z"),
        contacts: {
            skype: "leonard-hofstadter",
            vkontakte: "https://vk.com/leonard-hofstadter",
            facebook: "https://facebook.com/leonard-hofstadter",
            linkedin: "https://linkedin.com/leonard-hofstadter",
            github: "https://github.com/leonard-hofstadter"
        },
        completed: true,
        certificates: [{
            name: "Mongo certificate.jpg",
            largeUrl: "/media/certificates/f38348fb-c2c5-4109-ac1d-8f0b78c0caea.jpg",
            smallUrl: "/media/certificates/f38348fb-c2c5-4109-ac1d-8f0b78c0caea-sm.jpg"
        }],
        education: [{
            summary: "The specialist degree in Electronic Engineering",
            beginYear: 2006,
            finishYear: 2011,
            university: "Kharkiv National Technical University, Ukraine",
            faculty: "Computer Science"
        }],
        hobbies: [{name: "Singing"}, {name: "Codding"}, {name: "Bowling"}, {name: "Rowing"}, {name: "Games of chance"}],
        languages: [{name: "English", level: "BEGINNER", type: "WRITING"}, {
            name: "English",
            level: "BEGINNER",
            type: "SPOKEN"
        }],
        practics: [{
            position: "Java Advanced Course",
            company: "DevStudy.net",
            beginDate: new Date("2019-06-28T16:44:40.502Z"),
            responsibilities: "Developing the web application 'online-resume' using bootstrap HTML template, downloaded from intenet. Populating database by test data and uploading web project to AWS EC2 instance",
            demo: "http://LINK_TO_DEMO_SITE",
            github: "https://github.com/TODO"
        }, {
            position: "Java Base Course",
            company: "DevStudy.net",
            beginDate: new Date("2019-06-28T16:44:40.502Z"),
            responsibilities: "Developing the web application 'blog' using free HTML template, downloaded from intenet. Populating database by test data and uploading web project to OpenShift free hosting",
            demo: "http://LINK_TO_DEMO_SITE",
            github: "https://github.com/TODO"
        }],
        skills: [{idCategory: 1, category: "Languages", value: "Java, SQL, PLSQL"}, {
            idCategory: 2,
            category: "DBMS",
            value: "Postgresql"
        }, {idCategory: 3, category: "Web", value: "HTML, CSS, JS, Bootstrap, JQuery, Foundation"}, {
            idCategory: 4,
            category: "Java",
            value: "Spring MVC, Logback, JSP, JSTL, Spring Data JPA, Apache Commons, Spring Security, Hibernate JPA, Facebook Social API, Servlets, JDBC, Google+ Social API"
        }, {idCategory: 5, category: "IDE", value: "Eclipse for JEE Developer"}, {
            idCategory: 6,
            category: "CVS",
            value: "Git, Github"
        }, {idCategory: 7, category: "Web Servers", value: "Tomcat, Nginx"}, {
            idCategory: 8,
            category: "Build system",
            value: "Maven"
        }, {idCategory: 9, category: "Cloud", value: "AWS, OpenShift"}],
        courses: [{
            name: "Java Advanced Course",
            school: "SourceIt",
            finish_date: new Date("2011-06-30T16:44:40.450Z")
        }]
    }),
    db.profile.insert({
        uid: "leslie-winkle",
        firstName: "Leslie",
        lastName: "Winkle",
        birthDay: new Date("1994-12-04T17:44:40.504Z"),
        phone: "+380509613724",
        email: "leslie-winkle@gmail.com",
        country: "Ukraine",
        city: "Odessa",
        objective: "Junior java developer position",
        summary: "One Java professional course with developing web application resume (Link to demo is provided)",
        largePhoto: "/media/avatars/b25917b1-fc47-47e6-b509-ad7ba220ccc8.jpg",
        smallPhoto: "/media/avatars/b25917b1-fc47-47e6-b509-ad7ba220ccc8-sm.jpg",
        password: "$2a$10$q7732w6Rj3kZGhfDYSIXI.wFp.uwTSi2inB2rYHvm1iDIAf1J1eVq",
        created: new Date("2019-07-28T16:44:40.523Z"),
        contacts: {
            vkontakte: "https://vk.com/leslie-winkle",
            facebook: "https://facebook.com/leslie-winkle",
            linkedin: "https://linkedin.com/leslie-winkle",
            github: "https://github.com/leslie-winkle",
            stackoverflow: "https://stackoverflow.com/leslie-winkle"
        },
        completed: true,
        education: [{
            summary: "The specialist degree in Electronic Engineering",
            beginYear: 2010,
            finishYear: 2015,
            university: "Kharkiv National Technical University, Ukraine",
            faculty: "Computer Science"
        }],
        hobbies: [{name: "Cricket"}, {name: "Foreign lang"}, {name: "Singing"}, {name: "Fishing"}, {name: "Music"}],
        languages: [{name: "English", level: "INTERMEDIATE", type: "SPOKEN"}, {
            name: "English",
            level: "INTERMEDIATE",
            type: "WRITING"
        }, {name: "Italian", level: "PROFICIENCY", type: "SPOKEN"}, {
            name: "Italian",
            level: "PROFICIENCY",
            type: "WRITING"
        }],
        practics: [{
            position: "Java Advanced Course",
            company: "DevStudy.net",
            beginDate: new Date("2019-05-28T16:44:40.524Z"),
            finishDate: new Date("2019-06-28T16:44:40.524Z"),
            responsibilities: "Developing the web application 'online-resume' using bootstrap HTML template, downloaded from intenet. Populating database by test data and uploading web project to AWS EC2 instance",
            demo: "http://LINK_TO_DEMO_SITE",
            github: "https://github.com/TODO"
        }],
        skills: [{idCategory: 1, category: "Languages", value: "Java, SQL, PLSQL"}, {
            idCategory: 2,
            category: "DBMS",
            value: "Postgresql"
        }, {idCategory: 3, category: "Web", value: "HTML, CSS, JS, Bootstrap, JQuery"}, {
            idCategory: 4,
            category: "Java",
            value: "Spring MVC, Logback, JSP, JSTL, Spring Data JPA, Apache Commons, Spring Security, Hibernate JPA, Facebook Social API"
        }, {idCategory: 5, category: "IDE", value: "Eclipse for JEE Developer"}, {
            idCategory: 6,
            category: "CVS",
            value: "Git, Github"
        }, {idCategory: 7, category: "Web Servers", value: "Tomcat, Nginx"}, {
            idCategory: 8,
            category: "Build system",
            value: "Maven"
        }, {idCategory: 9, category: "Cloud", value: "AWS"}]
    }),
    db.profile.insert({
        uid: "logan-sanders",
        firstName: "Logan",
        lastName: "Sanders",
        birthDay: new Date("1992-08-20T16:44:40.530Z"),
        phone: "+380501166914",
        email: "logan-sanders@gmail.com",
        country: "Ukraine",
        city: "Odessa",
        objective: "Junior java developer position",
        summary: "Two Java professional courses with developing two web applications: blog and resume (Links to demo are provided)",
        largePhoto: "/media/avatars/a769bde8-8694-42ed-88a8-0053f7e15320.jpg",
        smallPhoto: "/media/avatars/a769bde8-8694-42ed-88a8-0053f7e15320-sm.jpg",
        info: "In consectetuer turpis ut velit. Nulla sit amet est. Praesent metus tellus, elementum eu, semper a, adipiscing nec, purus.",
        password: "$2a$10$q7732w6Rj3kZGhfDYSIXI.wFp.uwTSi2inB2rYHvm1iDIAf1J1eVq",
        created: new Date("2019-07-28T16:44:40.540Z"),
        contacts: {
            vkontakte: "https://vk.com/logan-sanders",
            facebook: "https://facebook.com/logan-sanders",
            github: "https://github.com/logan-sanders",
            stackoverflow: "https://stackoverflow.com/logan-sanders"
        },
        completed: true,
        certificates: [{
            name: "Mongo certificate.jpg",
            largeUrl: "/media/certificates/33359354-2c50-40d9-af2b-5687bf4fddac.jpg",
            smallUrl: "/media/certificates/33359354-2c50-40d9-af2b-5687bf4fddac-sm.jpg"
        }],
        education: [{
            summary: "The specialist degree in Electronic Engineering",
            beginYear: 2008,
            finishYear: 2013,
            university: "Kharkiv National Technical University, Ukraine",
            faculty: "Computer Science"
        }],
        hobbies: [{name: "Archery"}, {name: "Darts"}, {name: "Book reading"}, {name: "Photo"}, {name: "Badminton"}],
        languages: [{name: "English", level: "PROFICIENCY", type: "ALL"}, {
            name: "German",
            level: "INTERMEDIATE",
            type: "WRITING"
        }, {name: "German", level: "INTERMEDIATE", type: "SPOKEN"}],
        practics: [{
            position: "Java Advanced Course",
            company: "DevStudy.net",
            beginDate: new Date("2019-03-28T17:44:40.578Z"),
            finishDate: new Date("2019-04-28T16:44:40.578Z"),
            responsibilities: "Developing the web application 'online-resume' using bootstrap HTML template, downloaded from intenet. Populating database by test data and uploading web project to AWS EC2 instance",
            demo: "http://LINK_TO_DEMO_SITE",
            github: "https://github.com/TODO"
        }, {
            position: "Java Base Course",
            company: "DevStudy.net",
            beginDate: new Date("2019-01-28T17:44:40.578Z"),
            finishDate: new Date("2019-02-28T17:44:40.578Z"),
            responsibilities: "Developing the web application 'blog' using free HTML template, downloaded from intenet. Populating database by test data and uploading web project to OpenShift free hosting",
            demo: "http://LINK_TO_DEMO_SITE",
            github: "https://github.com/TODO"
        }],
        skills: [{idCategory: 1, category: "Languages", value: "Java, SQL, PLSQL"}, {
            idCategory: 2,
            category: "DBMS",
            value: "Postgresql"
        }, {idCategory: 3, category: "Web", value: "HTML, CSS, JS, Bootstrap, JQuery, Foundation"}, {
            idCategory: 4,
            category: "Java",
            value: "Spring MVC, Logback, JSP, JSTL, Spring Data JPA, Apache Commons, Spring Security, Hibernate JPA, Facebook Social API, Servlets, JDBC, Google+ Social API"
        }, {idCategory: 5, category: "IDE", value: "Eclipse for JEE Developer"}, {
            idCategory: 6,
            category: "CVS",
            value: "Git, Github"
        }, {idCategory: 7, category: "Web Servers", value: "Tomcat, Nginx"}, {
            idCategory: 8,
            category: "Build system",
            value: "Maven"
        }, {idCategory: 9, category: "Cloud", value: "AWS, OpenShift"}]
    }),
    db.profile.insert({
        uid: "maurice-moss",
        firstName: "Maurice",
        lastName: "Moss",
        birthDay: new Date("1990-11-08T16:44:40.580Z"),
        phone: "+380503235134",
        email: "maurice-moss@gmail.com",
        country: "Ukraine",
        city: "Odessa",
        objective: "Junior java developer position",
        summary: "Two Java professional courses with developing two web applications: blog and resume (Links to demo are provided)",
        largePhoto: "/media/avatars/90f5f5b4-2dae-48fd-b00d-84f8b76ea671.jpg",
        smallPhoto: "/media/avatars/90f5f5b4-2dae-48fd-b00d-84f8b76ea671-sm.jpg",
        info: "Curabitur ligula sapien, tincidunt non, euismod vitae, posuere imperdiet, leo. Maecenas malesuada. Praesent congue erat at massa.",
        password: "$2a$10$q7732w6Rj3kZGhfDYSIXI.wFp.uwTSi2inB2rYHvm1iDIAf1J1eVq",
        created: new Date("2019-07-28T16:44:40.590Z"),
        contacts: {
            skype: "maurice-moss",
            vkontakte: "https://vk.com/maurice-moss",
            facebook: "https://facebook.com/maurice-moss",
            linkedin: "https://linkedin.com/maurice-moss",
            github: "https://github.com/maurice-moss"
        },
        completed: true,
        certificates: [{
            name: "Mongo certificate.jpg",
            largeUrl: "/media/certificates/1093746a-31c3-444c-a8dd-128e4390408d.jpg",
            smallUrl: "/media/certificates/1093746a-31c3-444c-a8dd-128e4390408d-sm.jpg"
        }],
        education: [{
            summary: "The specialist degree in Electronic Engineering",
            beginYear: 2006,
            finishYear: 2011,
            university: "Kharkiv National Technical University, Ukraine",
            faculty: "Computer Science"
        }],
        hobbies: [{name: "Fishing"}, {name: "Bowling"}, {name: "Darts"}, {name: "Billiards"}, {name: "Baseball"}],
        languages: [{name: "English", level: "ADVANCED", type: "WRITING"}, {
            name: "English",
            level: "ADVANCED",
            type: "SPOKEN"
        }, {name: "Italian", level: "ELEMENTARY", type: "WRITING"}, {
            name: "Italian",
            level: "ELEMENTARY",
            type: "SPOKEN"
        }],
        practics: [{
            position: "Java Advanced Course",
            company: "DevStudy.net",
            beginDate: new Date("2019-04-28T16:44:40.642Z"),
            finishDate: new Date("2019-05-28T16:44:40.642Z"),
            responsibilities: "Developing the web application 'online-resume' using bootstrap HTML template, downloaded from intenet. Populating database by test data and uploading web project to AWS EC2 instance",
            demo: "http://LINK_TO_DEMO_SITE",
            github: "https://github.com/TODO"
        }, {
            position: "Java Base Course",
            company: "DevStudy.net",
            beginDate: new Date("2019-02-28T17:44:40.642Z"),
            finishDate: new Date("2019-03-28T17:44:40.642Z"),
            responsibilities: "Developing the web application 'blog' using free HTML template, downloaded from intenet. Populating database by test data and uploading web project to OpenShift free hosting",
            demo: "http://LINK_TO_DEMO_SITE",
            github: "https://github.com/TODO"
        }],
        skills: [{idCategory: 1, category: "Languages", value: "Java, SQL, PLSQL"}, {
            idCategory: 2,
            category: "DBMS",
            value: "Postgresql"
        }, {idCategory: 3, category: "Web", value: "HTML, CSS, JS, Bootstrap, JQuery, Foundation"}, {
            idCategory: 4,
            category: "Java",
            value: "Spring MVC, Logback, JSP, JSTL, Spring Data JPA, Apache Commons, Spring Security, Hibernate JPA, Facebook Social API, Servlets, JDBC, Google+ Social API"
        }, {idCategory: 5, category: "IDE", value: "Eclipse for JEE Developer"}, {
            idCategory: 6,
            category: "CVS",
            value: "Git, Github"
        }, {idCategory: 7, category: "Web Servers", value: "Tomcat, Nginx"}, {
            idCategory: 8,
            category: "Build system",
            value: "Maven"
        }, {idCategory: 9, category: "Cloud", value: "AWS, OpenShift"}]
    }),
    db.profile.insert({
        uid: "mike-ross",
        firstName: "Mike",
        lastName: "Ross",
        birthDay: new Date("1990-06-09T15:44:40.645Z"),
        phone: "+380504564568",
        email: "mike-ross@gmail.com",
        country: "Ukraine",
        city: "Kharkiv",
        objective: "Junior java developer position",
        summary: "Two Java professional courses with developing two web applications: blog and resume (Links to demo are provided)",
        largePhoto: "/media/avatars/803985f5-8ec8-4965-a563-1210af76f181.jpg",
        smallPhoto: "/media/avatars/803985f5-8ec8-4965-a563-1210af76f181-sm.jpg",
        password: "$2a$10$q7732w6Rj3kZGhfDYSIXI.wFp.uwTSi2inB2rYHvm1iDIAf1J1eVq",
        created: new Date("2019-07-28T16:44:40.656Z"),
        contacts: {
            facebook: "https://facebook.com/mike-ross",
            linkedin: "https://linkedin.com/mike-ross",
            github: "https://github.com/mike-ross",
            stackoverflow: "https://stackoverflow.com/mike-ross"
        },
        completed: true,
        certificates: [{
            name: "Jee certificate.jpg",
            largeUrl: "/media/certificates/8cb5dc14-2603-4a72-9962-9e07b73c36b6.jpg",
            smallUrl: "/media/certificates/8cb5dc14-2603-4a72-9962-9e07b73c36b6-sm.jpg"
        }],
        education: [{
            summary: "The specialist degree in Electronic Engineering",
            beginYear: 2007,
            finishYear: 2012,
            university: "Kharkiv National Technical University, Ukraine",
            faculty: "Computer Science"
        }],
        hobbies: [{name: "Skating"}, {name: "Animals"}, {name: "Cricket"}, {name: "Cooking"}, {name: "Foreign lang"}],
        languages: [{name: "English", level: "ADVANCED", type: "WRITING"}, {
            name: "English",
            level: "ADVANCED",
            type: "SPOKEN"
        }],
        practics: [{
            position: "Java Advanced Course",
            company: "DevStudy.net",
            beginDate: new Date("2019-04-28T16:44:40.690Z"),
            finishDate: new Date("2019-05-28T16:44:40.690Z"),
            responsibilities: "Developing the web application 'online-resume' using bootstrap HTML template, downloaded from intenet. Populating database by test data and uploading web project to AWS EC2 instance",
            demo: "http://LINK_TO_DEMO_SITE",
            github: "https://github.com/TODO"
        }, {
            position: "Java Base Course",
            company: "DevStudy.net",
            beginDate: new Date("2019-02-28T17:44:40.690Z"),
            finishDate: new Date("2019-03-28T17:44:40.690Z"),
            responsibilities: "Developing the web application 'blog' using free HTML template, downloaded from intenet. Populating database by test data and uploading web project to OpenShift free hosting",
            demo: "http://LINK_TO_DEMO_SITE",
            github: "https://github.com/TODO"
        }],
        skills: [{idCategory: 1, category: "Languages", value: "Java, SQL, PLSQL"}, {
            idCategory: 2,
            category: "DBMS",
            value: "Postgresql"
        }, {idCategory: 3, category: "Web", value: "HTML, CSS, JS, Bootstrap, JQuery, Foundation"}, {
            idCategory: 4,
            category: "Java",
            value: "Spring MVC, Logback, JSP, JSTL, Spring Data JPA, Apache Commons, Spring Security, Hibernate JPA, Facebook Social API, Servlets, JDBC, Google+ Social API"
        }, {idCategory: 5, category: "IDE", value: "Eclipse for JEE Developer"}, {
            idCategory: 6,
            category: "CVS",
            value: "Git, Github"
        }, {idCategory: 7, category: "Web Servers", value: "Tomcat, Nginx"}, {
            idCategory: 8,
            category: "Build system",
            value: "Maven"
        }, {idCategory: 9, category: "Cloud", value: "AWS, OpenShift"}],
        courses: [{
            name: "Java Advanced Course",
            school: "SourceIt",
            finish_date: new Date("2013-06-30T16:44:40.645Z")
        }]
    }),
    db.profile.insert({
        uid: "rachel-zane",
        firstName: "Rachel",
        lastName: "Zane",
        birthDay: new Date("1989-11-25T16:44:40.692Z"),
        phone: "+380503144274",
        email: "rachel-zane@gmail.com",
        country: "Ukraine",
        city: "Kharkiv",
        objective: "Junior java trainee position",
        summary: "One Java professional course with developing web application blog (Link to demo is provided)",
        largePhoto: "/media/avatars/47a334e3-941f-45b2-bbed-f15f8cfd7741.jpg",
        smallPhoto: "/media/avatars/47a334e3-941f-45b2-bbed-f15f8cfd7741-sm.jpg",
        info: "Fusce vulputate eleifend sapien. Vestibulum purus quam, scelerisque ut, mollis sed, nonummy id, metus. Nullam accumsan lorem in dui.",
        password: "$2a$10$q7732w6Rj3kZGhfDYSIXI.wFp.uwTSi2inB2rYHvm1iDIAf1J1eVq",
        created: new Date("2019-07-28T16:44:40.725Z"),
        contacts: {linkedin: "https://linkedin.com/rachel-zane", github: "https://github.com/rachel-zane"},
        completed: true,
        education: [{
            summary: "The specialist degree in Electronic Engineering",
            beginYear: 2006,
            finishYear: 2011,
            university: "Kharkiv National Technical University, Ukraine",
            faculty: "Computer Science"
        }],
        hobbies: [{name: "Kayak slalom"}, {name: "Cycling"}, {name: "Badminton"}, {name: "Tennis"}, {name: "Book reading"}],
        languages: [{name: "English", level: "ADVANCED", type: "ALL"}, {
            name: "Italian",
            level: "INTERMEDIATE",
            type: "WRITING"
        }, {name: "Italian", level: "INTERMEDIATE", type: "SPOKEN"}],
        practics: [{
            position: "Java Base Course",
            company: "DevStudy.net",
            beginDate: new Date("2019-06-28T16:44:40.726Z"),
            responsibilities: "Developing the web application 'blog' using free HTML template, downloaded from intenet. Populating database by test data and uploading web project to OpenShift free hosting",
            demo: "http://LINK_TO_DEMO_SITE",
            github: "https://github.com/TODO"
        }],
        skills: [{idCategory: 1, category: "Languages", value: "Java, SQL"}, {
            idCategory: 2,
            category: "DBMS",
            value: "Postgresql"
        }, {idCategory: 3, category: "Web", value: "HTML, CSS, JS, Foundation, JQuery"}, {
            idCategory: 4,
            category: "Java",
            value: "Servlets, Logback, JSP, JSTL, JDBC, Apache Commons, Google+ Social API"
        }, {idCategory: 5, category: "IDE", value: "Eclipse for JEE Developer"}, {
            idCategory: 6,
            category: "CVS",
            value: "Git, Github"
        }, {idCategory: 7, category: "Web Servers", value: "Tomcat"}, {
            idCategory: 8,
            category: "Build system",
            value: "Maven"
        }, {idCategory: 9, category: "Cloud", value: "OpenShift"}]
    }),
    db.profile.insert({
        uid: "rajesh-koothrappali",
        firstName: "Rajesh",
        lastName: "Koothrappali",
        birthDay: new Date("1996-01-09T17:44:40.727Z"),
        phone: "+380509318472",
        email: "rajesh-koothrappali@gmail.com",
        country: "Ukraine",
        city: "Odessa",
        objective: "Junior java developer position",
        summary: "Two Java professional courses with developing two web applications: blog and resume (Links to demo are provided)",
        largePhoto: "/media/avatars/be943430-11c0-4fff-8741-32acb884645c.jpg",
        smallPhoto: "/media/avatars/be943430-11c0-4fff-8741-32acb884645c-sm.jpg",
        password: "$2a$10$q7732w6Rj3kZGhfDYSIXI.wFp.uwTSi2inB2rYHvm1iDIAf1J1eVq",
        created: new Date("2019-07-28T16:44:40.736Z"),
        contacts: {
            vkontakte: "https://vk.com/rajesh-koothrappali",
            facebook: "https://facebook.com/rajesh-koothrappali",
            github: "https://github.com/rajesh-koothrappali"
        },
        completed: true,
        certificates: [{
            name: "Jee certificate.jpg",
            largeUrl: "/media/certificates/20aa7b59-f324-4434-b61f-f4de4e60eb98.jpg",
            smallUrl: "/media/certificates/20aa7b59-f324-4434-b61f-f4de4e60eb98-sm.jpg"
        }, {
            name: "Mongo certificate.jpg",
            largeUrl: "/media/certificates/7ce8bb09-05e1-4683-8a66-3d5b19ec7ddb.jpg",
            smallUrl: "/media/certificates/7ce8bb09-05e1-4683-8a66-3d5b19ec7ddb-sm.jpg"
        }],
        education: [{
            summary: "The specialist degree in Electronic Engineering",
            beginYear: 2014,
            finishYear: 2019,
            university: "Kharkiv National Technical University, Ukraine",
            faculty: "Computer Science"
        }],
        hobbies: [{name: "Cycling"}, {name: "Skiing"}, {name: "Volleyball"}, {name: "Authorship"}, {name: "Weightlifting"}],
        languages: [{name: "English", level: "UPPER_INTERMEDIATE", type: "SPOKEN"}, {
            name: "English",
            level: "UPPER_INTERMEDIATE",
            type: "WRITING"
        }, {name: "Spanish", level: "ADVANCED", type: "WRITING"}, {
            name: "Spanish",
            level: "ADVANCED",
            type: "SPOKEN"
        }],
        practics: [{
            position: "Java Advanced Course",
            company: "DevStudy.net",
            beginDate: new Date("2019-05-28T16:44:40.822Z"),
            finishDate: new Date("2019-06-28T16:44:40.822Z"),
            responsibilities: "Developing the web application 'online-resume' using bootstrap HTML template, downloaded from intenet. Populating database by test data and uploading web project to AWS EC2 instance",
            demo: "http://LINK_TO_DEMO_SITE",
            github: "https://github.com/TODO"
        }, {
            position: "Java Base Course",
            company: "DevStudy.net",
            beginDate: new Date("2019-02-28T17:44:40.822Z"),
            finishDate: new Date("2019-03-28T17:44:40.822Z"),
            responsibilities: "Developing the web application 'blog' using free HTML template, downloaded from intenet. Populating database by test data and uploading web project to OpenShift free hosting",
            demo: "http://LINK_TO_DEMO_SITE",
            github: "https://github.com/TODO"
        }],
        skills: [{idCategory: 1, category: "Languages", value: "Java, SQL, PLSQL"}, {
            idCategory: 2,
            category: "DBMS",
            value: "Postgresql"
        }, {idCategory: 3, category: "Web", value: "HTML, CSS, JS, Bootstrap, JQuery, Foundation"}, {
            idCategory: 4,
            category: "Java",
            value: "Spring MVC, Logback, JSP, JSTL, Spring Data JPA, Apache Commons, Spring Security, Hibernate JPA, Facebook Social API, Servlets, JDBC, Google+ Social API"
        }, {idCategory: 5, category: "IDE", value: "Eclipse for JEE Developer"}, {
            idCategory: 6,
            category: "CVS",
            value: "Git, Github"
        }, {idCategory: 7, category: "Web Servers", value: "Tomcat, Nginx"}, {
            idCategory: 8,
            category: "Build system",
            value: "Maven"
        }, {idCategory: 9, category: "Cloud", value: "AWS, OpenShift"}]
    }),
    db.profile.insert({
        uid: "richard-hendricks",
        firstName: "Richard",
        lastName: "Hendricks",
        birthDay: new Date("1991-12-18T17:44:40.823Z"),
        phone: "+380502973776",
        email: "richard-hendricks@gmail.com",
        country: "Ukraine",
        city: "Odessa",
        objective: "Junior java developer position",
        summary: "Two Java professional courses with developing two web applications: blog and resume (Links to demo are provided)",
        largePhoto: "/media/avatars/8aa4c6e5-5f08-4fe4-981e-79043f774d14.jpg",
        smallPhoto: "/media/avatars/8aa4c6e5-5f08-4fe4-981e-79043f774d14-sm.jpg",
        password: "$2a$10$q7732w6Rj3kZGhfDYSIXI.wFp.uwTSi2inB2rYHvm1iDIAf1J1eVq",
        created: new Date("2019-07-28T16:44:40.836Z"),
        contacts: {
            skype: "richard-hendricks",
            vkontakte: "https://vk.com/richard-hendricks",
            github: "https://github.com/richard-hendricks",
            stackoverflow: "https://stackoverflow.com/richard-hendricks"
        },
        completed: true,
        certificates: [{
            name: "Mongo certificate.jpg",
            largeUrl: "/media/certificates/0c1ca398-8216-42c7-8ef6-7e49c372499e.jpg",
            smallUrl: "/media/certificates/0c1ca398-8216-42c7-8ef6-7e49c372499e-sm.jpg"
        }],
        education: [{
            summary: "The specialist degree in Electronic Engineering",
            beginYear: 2007,
            finishYear: 2012,
            university: "Kharkiv National Technical University, Ukraine",
            faculty: "Computer Science"
        }],
        hobbies: [{name: "Baseball"}, {name: "Animals"}, {name: "Skiing"}, {name: "Collecting"}, {name: "Weightlifting"}],
        languages: [{name: "English", level: "ELEMENTARY", type: "ALL"}],
        practics: [{
            position: "Java Advanced Course",
            company: "DevStudy.net",
            beginDate: new Date("2019-06-28T16:44:40.873Z"),
            responsibilities: "Developing the web application 'online-resume' using bootstrap HTML template, downloaded from intenet. Populating database by test data and uploading web project to AWS EC2 instance",
            demo: "http://LINK_TO_DEMO_SITE",
            github: "https://github.com/TODO"
        }, {
            position: "Java Base Course",
            company: "DevStudy.net",
            beginDate: new Date("2019-06-28T16:44:40.873Z"),
            responsibilities: "Developing the web application 'blog' using free HTML template, downloaded from intenet. Populating database by test data and uploading web project to OpenShift free hosting",
            demo: "http://LINK_TO_DEMO_SITE",
            github: "https://github.com/TODO"
        }],
        skills: [{idCategory: 1, category: "Languages", value: "Java, SQL, PLSQL"}, {
            idCategory: 2,
            category: "DBMS",
            value: "Postgresql"
        }, {idCategory: 3, category: "Web", value: "HTML, CSS, JS, Bootstrap, JQuery, Foundation"}, {
            idCategory: 4,
            category: "Java",
            value: "Spring MVC, Logback, JSP, JSTL, Spring Data JPA, Apache Commons, Spring Security, Hibernate JPA, Facebook Social API, Servlets, JDBC, Google+ Social API"
        }, {idCategory: 5, category: "IDE", value: "Eclipse for JEE Developer"}, {
            idCategory: 6,
            category: "CVS",
            value: "Git, Github"
        }, {idCategory: 7, category: "Web Servers", value: "Tomcat, Nginx"}, {
            idCategory: 8,
            category: "Build system",
            value: "Maven"
        }, {idCategory: 9, category: "Cloud", value: "AWS, OpenShift"}],
        courses: [{
            name: "Java Advanced Course",
            school: "SourceIt",
            finish_date: new Date("2012-06-30T16:44:40.823Z")
        }]
    }),
    db.profile.insert({
        uid: "roy-trenneman",
        firstName: "Roy",
        lastName: "Trenneman",
        birthDay: new Date("1993-09-14T16:44:40.874Z"),
        phone: "+380505545864",
        email: "roy-trenneman@gmail.com",
        country: "Ukraine",
        city: "Kharkiv",
        objective: "Junior java developer position",
        summary: "One Java professional course with developing web application resume (Link to demo is provided)",
        largePhoto: "/media/avatars/6811344e-26de-407d-bd82-cef467878716.jpg",
        smallPhoto: "/media/avatars/6811344e-26de-407d-bd82-cef467878716-sm.jpg",
        password: "$2a$10$q7732w6Rj3kZGhfDYSIXI.wFp.uwTSi2inB2rYHvm1iDIAf1J1eVq",
        created: new Date("2019-07-28T16:44:40.885Z"),
        contacts: {
            skype: "roy-trenneman",
            linkedin: "https://linkedin.com/roy-trenneman",
            stackoverflow: "https://stackoverflow.com/roy-trenneman"
        },
        completed: true,
        certificates: [{
            name: "Mongo certificate.jpg",
            largeUrl: "/media/certificates/1dd6a52a-310a-4e0c-a56c-1780783f419d.jpg",
            smallUrl: "/media/certificates/1dd6a52a-310a-4e0c-a56c-1780783f419d-sm.jpg"
        }],
        education: [{
            summary: "The specialist degree in Electronic Engineering",
            beginYear: 2010,
            finishYear: 2015,
            university: "Kharkiv National Technical University, Ukraine",
            faculty: "Computer Science"
        }],
        hobbies: [{name: "Skating"}, {name: "Cricket"}, {name: "Painting"}, {name: "Computer games"}, {name: "Football"}],
        languages: [{name: "English", level: "PROFICIENCY", type: "SPOKEN"}, {
            name: "English",
            level: "PROFICIENCY",
            type: "WRITING"
        }, {name: "German", level: "BEGINNER", type: "SPOKEN"}, {
            name: "German",
            level: "BEGINNER",
            type: "WRITING"
        }],
        practics: [{
            position: "Java Advanced Course",
            company: "DevStudy.net",
            beginDate: new Date("2019-05-28T16:44:40.935Z"),
            finishDate: new Date("2019-06-28T16:44:40.935Z"),
            responsibilities: "Developing the web application 'online-resume' using bootstrap HTML template, downloaded from intenet. Populating database by test data and uploading web project to AWS EC2 instance",
            demo: "http://LINK_TO_DEMO_SITE",
            github: "https://github.com/TODO"
        }],
        skills: [{idCategory: 1, category: "Languages", value: "Java, SQL, PLSQL"}, {
            idCategory: 2,
            category: "DBMS",
            value: "Postgresql"
        }, {idCategory: 3, category: "Web", value: "HTML, CSS, JS, Bootstrap, JQuery"}, {
            idCategory: 4,
            category: "Java",
            value: "Spring MVC, Logback, JSP, JSTL, Spring Data JPA, Apache Commons, Spring Security, Hibernate JPA, Facebook Social API"
        }, {idCategory: 5, category: "IDE", value: "Eclipse for JEE Developer"}, {
            idCategory: 6,
            category: "CVS",
            value: "Git, Github"
        }, {idCategory: 7, category: "Web Servers", value: "Tomcat, Nginx"}, {
            idCategory: 8,
            category: "Build system",
            value: "Maven"
        }, {idCategory: 9, category: "Cloud", value: "AWS"}],
        courses: [{
            name: "Java Advanced Course",
            school: "SourceIt",
            finish_date: new Date("2014-06-30T16:44:40.874Z")
        }]
    }),
    db.profile.insert({
        uid: "sheldon-cooper",
        firstName: "Sheldon",
        lastName: "Cooper",
        birthDay: new Date("1991-04-01T16:44:40.937Z"),
        phone: "+380507161415",
        email: "sheldon-cooper@gmail.com",
        country: "Ukraine",
        city: "Odessa",
        objective: "Junior java developer position",
        summary: "Two Java professional courses with developing two web applications: blog and resume (Links to demo are provided)",
        largePhoto: "/media/avatars/1a04e565-acfc-4455-b4ce-dd9a1c1779e3.jpg",
        smallPhoto: "/media/avatars/1a04e565-acfc-4455-b4ce-dd9a1c1779e3-sm.jpg",
        password: "$2a$10$q7732w6Rj3kZGhfDYSIXI.wFp.uwTSi2inB2rYHvm1iDIAf1J1eVq",
        created: new Date("2019-07-28T16:44:40.946Z"),
        contacts: {
            skype: "sheldon-cooper",
            vkontakte: "https://vk.com/sheldon-cooper",
            linkedin: "https://linkedin.com/sheldon-cooper"
        },
        completed: true,
        certificates: [{
            name: "Mongo certificate.jpg",
            largeUrl: "/media/certificates/ad115d29-f70d-44c6-a952-6e5ec37b3e47.jpg",
            smallUrl: "/media/certificates/ad115d29-f70d-44c6-a952-6e5ec37b3e47-sm.jpg"
        }],
        education: [{
            summary: "The specialist degree in Electronic Engineering",
            beginYear: 2009,
            finishYear: 2014,
            university: "Kharkiv National Technical University, Ukraine",
            faculty: "Computer Science"
        }],
        hobbies: [{name: "Traveling"}, {name: "Diving"}, {name: "Archery"}, {name: "Rowing"}, {name: "Cricket"}],
        languages: [{name: "English", level: "BEGINNER", type: "ALL"}],
        practics: [{
            position: "Java Advanced Course",
            company: "DevStudy.net",
            beginDate: new Date("2019-03-28T17:44:41.011Z"),
            finishDate: new Date("2019-04-28T16:44:41.011Z"),
            responsibilities: "Developing the web application 'online-resume' using bootstrap HTML template, downloaded from intenet. Populating database by test data and uploading web project to AWS EC2 instance",
            demo: "http://LINK_TO_DEMO_SITE",
            github: "https://github.com/TODO"
        }, {
            position: "Java Base Course",
            company: "DevStudy.net",
            beginDate: new Date("2019-02-28T17:44:41.011Z"),
            finishDate: new Date("2019-03-28T17:44:41.011Z"),
            responsibilities: "Developing the web application 'blog' using free HTML template, downloaded from intenet. Populating database by test data and uploading web project to OpenShift free hosting",
            demo: "http://LINK_TO_DEMO_SITE",
            github: "https://github.com/TODO"
        }],
        skills: [{idCategory: 1, category: "Languages", value: "Java, SQL, PLSQL"}, {
            idCategory: 2,
            category: "DBMS",
            value: "Postgresql"
        }, {idCategory: 3, category: "Web", value: "HTML, CSS, JS, Bootstrap, JQuery, Foundation"}, {
            idCategory: 4,
            category: "Java",
            value: "Spring MVC, Logback, JSP, JSTL, Spring Data JPA, Apache Commons, Spring Security, Hibernate JPA, Facebook Social API, Servlets, JDBC, Google+ Social API"
        }, {idCategory: 5, category: "IDE", value: "Eclipse for JEE Developer"}, {
            idCategory: 6,
            category: "CVS",
            value: "Git, Github"
        }, {idCategory: 7, category: "Web Servers", value: "Tomcat, Nginx"}, {
            idCategory: 8,
            category: "Build system",
            value: "Maven"
        }, {idCategory: 9, category: "Cloud", value: "AWS, OpenShift"}],
        courses: [{
            name: "Java Advanced Course",
            school: "SourceIt",
            finish_date: new Date("2012-06-30T16:44:40.937Z")
        }]
    }),
    db.profile.insert({
        uid: "stuart-bloom",
        firstName: "Stuart",
        lastName: "Bloom",
        birthDay: new Date("1995-04-30T16:44:41.013Z"),
        phone: "+380505363329",
        email: "stuart-bloom@gmail.com",
        country: "Ukraine",
        city: "Kharkiv",
        objective: "Junior java developer position",
        summary: "One Java professional course with developing web application resume (Link to demo is provided)",
        largePhoto: "/media/avatars/fbd3baad-4300-4a0b-8df7-aa5605a0e6e7.jpg",
        smallPhoto: "/media/avatars/fbd3baad-4300-4a0b-8df7-aa5605a0e6e7-sm.jpg",
        info: "Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim.",
        password: "$2a$10$q7732w6Rj3kZGhfDYSIXI.wFp.uwTSi2inB2rYHvm1iDIAf1J1eVq",
        created: new Date("2019-07-28T16:44:41.046Z"),
        contacts: {
            skype: "stuart-bloom",
            linkedin: "https://linkedin.com/stuart-bloom",
            github: "https://github.com/stuart-bloom",
            stackoverflow: "https://stackoverflow.com/stuart-bloom"
        },
        completed: true,
        certificates: [{
            name: "Jee certificate.jpg",
            largeUrl: "/media/certificates/0f4d3a22-04ab-4278-b547-646edc08b4e1.jpg",
            smallUrl: "/media/certificates/0f4d3a22-04ab-4278-b547-646edc08b4e1-sm.jpg"
        }],
        education: [{
            summary: "The specialist degree in Electronic Engineering",
            beginYear: 2011,
            finishYear: 2016,
            university: "Kharkiv National Technical University, Ukraine",
            faculty: "Computer Science"
        }],
        hobbies: [{name: "Baseball"}, {name: "Handball"}, {name: "Computer games"}, {name: "Automobiles"}, {name: "Skiing"}],
        languages: [{name: "English", level: "PROFICIENCY", type: "WRITING"}, {
            name: "English",
            level: "PROFICIENCY",
            type: "SPOKEN"
        }, {name: "Italian", level: "PROFICIENCY", type: "ALL"}],
        practics: [{
            position: "Java Advanced Course",
            company: "DevStudy.net",
            beginDate: new Date("2019-06-28T16:44:41.079Z"),
            responsibilities: "Developing the web application 'online-resume' using bootstrap HTML template, downloaded from intenet. Populating database by test data and uploading web project to AWS EC2 instance",
            demo: "http://LINK_TO_DEMO_SITE",
            github: "https://github.com/TODO"
        }],
        skills: [{idCategory: 1, category: "Languages", value: "Java, SQL, PLSQL"}, {
            idCategory: 2,
            category: "DBMS",
            value: "Postgresql"
        }, {idCategory: 3, category: "Web", value: "HTML, CSS, JS, Bootstrap, JQuery"}, {
            idCategory: 4,
            category: "Java",
            value: "Spring MVC, Logback, JSP, JSTL, Spring Data JPA, Apache Commons, Spring Security, Hibernate JPA, Facebook Social API"
        }, {idCategory: 5, category: "IDE", value: "Eclipse for JEE Developer"}, {
            idCategory: 6,
            category: "CVS",
            value: "Git, Github"
        }, {idCategory: 7, category: "Web Servers", value: "Tomcat, Nginx"}, {
            idCategory: 8,
            category: "Build system",
            value: "Maven"
        }, {idCategory: 9, category: "Cloud", value: "AWS"}],
        courses: [{
            name: "Java Advanced Course",
            school: "SourceIt",
            finish_date: new Date("2017-06-30T16:44:41.013Z")
        }]
    }),
    db.profile.insert({
        uid: "trevor-evans",
        firstName: "Trevor",
        lastName: "Evans",
        birthDay: new Date("1993-09-21T16:44:41.087Z"),
        phone: "+380506639246",
        email: "trevor-evans@gmail.com",
        country: "Ukraine",
        city: "Odessa",
        objective: "Junior java developer position",
        summary: "Two Java professional courses with developing two web applications: blog and resume (Links to demo are provided)",
        largePhoto: "/media/avatars/de5ae683-29ff-4d1e-85a9-c63db1a3e417.jpg",
        smallPhoto: "/media/avatars/de5ae683-29ff-4d1e-85a9-c63db1a3e417-sm.jpg",
        password: "$2a$10$q7732w6Rj3kZGhfDYSIXI.wFp.uwTSi2inB2rYHvm1iDIAf1J1eVq",
        created: new Date("2019-07-28T16:44:41.122Z"),
        contacts: {
            skype: "trevor-evans",
            vkontakte: "https://vk.com/trevor-evans",
            facebook: "https://facebook.com/trevor-evans"
        },
        completed: true,
        certificates: [{
            name: "Mongo certificate.jpg",
            largeUrl: "/media/certificates/406cafe3-e334-4149-b1e9-71b3f94c3049.jpg",
            smallUrl: "/media/certificates/406cafe3-e334-4149-b1e9-71b3f94c3049-sm.jpg"
        }],
        education: [{
            summary: "The specialist degree in Electronic Engineering",
            beginYear: 2010,
            finishYear: 2015,
            university: "Kharkiv National Technical University, Ukraine",
            faculty: "Computer Science"
        }],
        hobbies: [{name: "Rowing"}, {name: "Disco"}, {name: "Pubs"}, {name: "Bowling"}, {name: "Fishing"}],
        languages: [{name: "English", level: "UPPER_INTERMEDIATE", type: "WRITING"}, {
            name: "English",
            level: "UPPER_INTERMEDIATE",
            type: "SPOKEN"
        }, {name: "Spanish", level: "UPPER_INTERMEDIATE", type: "SPOKEN"}, {
            name: "Spanish",
            level: "UPPER_INTERMEDIATE",
            type: "WRITING"
        }],
        practics: [{
            position: "Java Advanced Course",
            company: "DevStudy.net",
            beginDate: new Date("2019-06-28T16:44:41.155Z"),
            responsibilities: "Developing the web application 'online-resume' using bootstrap HTML template, downloaded from intenet. Populating database by test data and uploading web project to AWS EC2 instance",
            demo: "http://LINK_TO_DEMO_SITE",
            github: "https://github.com/TODO"
        }, {
            position: "Java Base Course",
            company: "DevStudy.net",
            beginDate: new Date("2019-06-28T16:44:41.155Z"),
            responsibilities: "Developing the web application 'blog' using free HTML template, downloaded from intenet. Populating database by test data and uploading web project to OpenShift free hosting",
            demo: "http://LINK_TO_DEMO_SITE",
            github: "https://github.com/TODO"
        }],
        skills: [{idCategory: 1, category: "Languages", value: "Java, SQL, PLSQL"}, {
            idCategory: 2,
            category: "DBMS",
            value: "Postgresql"
        }, {idCategory: 3, category: "Web", value: "HTML, CSS, JS, Bootstrap, JQuery, Foundation"}, {
            idCategory: 4,
            category: "Java",
            value: "Spring MVC, Logback, JSP, JSTL, Spring Data JPA, Apache Commons, Spring Security, Hibernate JPA, Facebook Social API, Servlets, JDBC, Google+ Social API"
        }, {idCategory: 5, category: "IDE", value: "Eclipse for JEE Developer"}, {
            idCategory: 6,
            category: "CVS",
            value: "Git, Github"
        }, {idCategory: 7, category: "Web Servers", value: "Tomcat, Nginx"}, {
            idCategory: 8,
            category: "Build system",
            value: "Maven"
        }, {idCategory: 9, category: "Cloud", value: "AWS, OpenShift"}]
    })
];
// Skill categories
let skillCategoryResults = [
    db.skillCategory.insert({idCategory: 1, category: "Languages"}),
    db.skillCategory.insert({idCategory: 2, category: "DBMS"}),
    db.skillCategory.insert({idCategory: 3, category: "Web"}),
    db.skillCategory.insert({idCategory: 4, category: "Java"}),
    db.skillCategory.insert({idCategory: 5, category: "IDE"}),
    db.skillCategory.insert({idCategory: 6, category: "CVS"}),
    db.skillCategory.insert({idCategory: 7, category: "Web Servers"}),
    db.skillCategory.insert({idCategory: 8, category: "Build system"}),
    db.skillCategory.insert({idCategory: 9, category: "Cloud"}),
];
// Indexes
let indexResults = [
    db.profile.createIndex({email: 1}, {name: "email_idx", unique: true}),
    db.profile.createIndex({phone: 1}, {name: "phone_idx", unique: true}),
    db.profile.createIndex({uid: 1}, {name: "uid_idx", unique: true}),
    db.profile.createIndex({completed: 1}, {name: "completed_idx", unique: false}),
    db.profile.createIndex({created: 1}, {name: "created_idx", unique: false}),

    db.profileRestore.createIndex({token: 1}, {name: "token_idx", unique: true}),

    db.rememberMeToken.createIndex({series: 1}, {name: "series_idx", unique: true}),
    db.rememberMeToken.createIndex({username: 1}, {name: "username_idx", unique: false})
];
// Print results:
printjson(profileResults);
printjson(skillCategoryResults);
printjson(indexResults);