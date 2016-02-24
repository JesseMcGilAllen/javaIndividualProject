# Journal

[Time Log](TimeLog.md)

### Week 1

1/20/2016

Completed:
  - Created this repository

1/25/2016

Completed:
  - Wrote the problem statement
  - Choose project goal

1/26/2016

Completed:
  - Started documenting project progress
  - Started working on project plan

---

I have an idea for where I want to go with this project.  Right now I am struggling to come up with the independent technology to use for it.  I hope that in the next week or so, when I flesh out the project more, I will have a better idea of what that independent technology could be.  

I am also concerned that I will making too major decisions concerning the project within the next two weeks.  Perhaps, it wold be better to space out the necessary items a little bit more in the project plan.

### Week 2

1/31/2016

Completed:
  - Sketched out rough screen design

2/1/2016

Completed:
  - Decided on topic for first presentation

2/2/2016

Completed:
  - Documented Screen Design for Repository

2/3/2016

Completed:
  - Created IntelliJ project
  - Added JUnit and Log4J Libraries

---

One unexpected issue I came across this week dealt with the orientation of pictures I was uploading for my screen design.  When uploaded, some of them displayed upside down.  After a little Googling, it turns out that I had to open each one and resave it.  After uploading the photos again the orientation was correct.  It was an amusing and annoying little bug.

I struggled for a long time to come up with an ExtraCurricular Activity that interests me for the first presentation.  My decision was partially hampered by having class on Monday and Wednesday nights, which limits my meetup options.  I finally decided on giving a presentation comparing Java and Scala.  I interested in discovering what I find.  I believe it will also be challenging fitting everything in 10-20 minutes.  Especially with Scala going to be a completely new discovery to the majority of my audience(myself included!).

I had to push some things back in my Project Plan.  I hit upon quite a number of problems trying to complete the exercises for week 2.  I ran into one of those bugs where the file got corrupted somehow and IntelliJ kept discovered bad characters that prevented me from running anything.  I resolved that by deleting the entire contents of the file and retyping everything.

The second issue I had with the exercises was trying determine the difference between a negative test and an exception test.  I got deep in the weeds on this one and still don't know if there is one.

### Week 3

02/10/2016

Completed:
  - Started implementing Hiberate
  - Created a User DAO
  - Started implementing Unit Testing
  - Started implementing Logging

I am either not that great at planning or looking ahead, as I needed to make another change to my Project Plan.  With the Hibernate implementation exercise due next week, I figure I might as well move the database stuff up to this week.

I have been having a rough week.  I got sick over the weekend, which restricted how much time I could spend on things.  Subsequently, I haven't started the JSPs yet, so those got pushed back yet again.  I am also getting in my own way mentally, feeling very unsure of myself about the class.

Anyway, yesterday I used the weekly exercise as an opportunity to start implementing Hiberate, Unit Testing, and Logging into my project.  I found a nice article called [Simple CRUD Using Java, Hiberate and MySql](https://danielniko.wordpress.com/2012/12/03/simple-crud-using-java-hibernate-and-mysql/) that helped me fill in the gaps needed to implement the UserDao.  I mostly used that as a guide and then fixing and debugging things when writing the tests.  I found that when I ran into an issue, my logging level was set to low and finding the right information in the log was not easy.  After setting the logging level higher, it was easier to see where I went wrong. 

Another issue that came up during testing was maintaining the database when running tests.  In Rails, everything is run in a test database to not affect the actual data.  However, when I added a user to the database in the @Before method it added before every test understandibly.  However, I had troubling clearing them. I spent an hour or two trying to clear the database in teardown but then realized that doesn't work when actually implementing the database for the site.  I know that it shouldn't affect the production deploy but there must be a better way.

When I was pushing up my progress I ran into quite the git issue.  It turns out I had committed a log file before adding to the gitignore and removing the cached file.  It turns out that once it is the commit log it is there.  Github refused to let me push my changes because it wanted to push the 800Mb file.  After trying after Git command that I knew, I stumbled upon ``git filter-branch --index-filter 'git rm --cached --ignore-unmatch FILENAME'``  From this [article](http://www.thisprogrammingthing.com/2013/fixing-the-this-exceeds-githubs-file-size-limit-of-100-mb-error/).  That seems to have fixed the issue.

## Week 4

02/17/2016

Completed: 
  - adding JSTL support for JSP templating.

I talked to Paula after class and she alleviated some of my concerns with the class.  Between talking with her and Eric, I recognize that I need to code in order to understand things.  I do not pick things up by just reading or watching videos.  I have to try things for myself and then research as necessary.

I have been spending a lot of time brainstorming and research an idea for iOS n the last week.  The idea is exciting and quite a substantial project.  With the iOS project and my acknowledged struggles job-hunting, I think I am going to pivot my focus to that.  

My iOS team project has once again started out as a disaster.  Each of the last two weekends a team member has dropped and now I am all alone.  Luckily, Eric was able to convince someone to join me as a team so the designers wouldn't have scattered.  Hoping my curse of team doesn't extend to this class.

I found a temporary solution to my database overpopulating with test data.  I need to do further research on the possibility of setting up a test database.  This [StackOverflow post](http://stackoverflow.com/questions/21576206/separate-db-just-for-junit-tests-in-spring-app) has lead me to add Spring profiles as something to research as a solution to the problem.  I have added Spring to the as a todo in the Project Plan for next week.  I think it would worthwhile subject to research due to its prevalence in the Java related job postings that I have seen.

I finally started working on the JSPs!  I am using my ancient Advanced Java project as a guide and created a doctype jsp.  After connecting it to the index page, I saw IntelliJ complaining.  I had to JSTL jars to the project which makes sense.  However, that was a lot harder then I originally thought.  I ended up finding them on [Tomcat's website](http://tomcat.apache.org/download-taglibs.cgi) and finally downloaded the right one (binary).  IntelliJ has stopped complaining, so hopefully they work.

It seems I have broken everything when I moved from using Copy to iCloud.  All the paths are different.  Got Tomee working again.  

I have decided to change the emphasis of my project to a personal programming review type site.  Of course, it makes the site more complicated.  Which strangely makes the project more appealing.

Unfortunately, I wasn't able to get start on User Authentication before class.  It looked like jsps were necessary.  I got caught up with implementing the JSTLs.

## Week 5

2/18/2016

Completed:
  Implementing administrator user role on one page
  
2/22/2016

Completed:
  Implementing registered user role
  Adding Testing Database

2/23/2016

Completed:
  Created new JSP structure for current roles

2/24/2016

Completed:
  Adding needed jsps
---

I finally had success implementing login into my project.  It require to major debugging sessions with Paula and Matt.  In the end, the problem was in the jsps.  I forgot the name="j_username" attribute.  Its a simple thing to forget and we were focused on the more complicated elements of the implementation, namely the xml file configurations.  What lead me down the path of the fix was enabling Realm logging for my project.  I found a [blogspot post](http://dev-answers.blogspot.com/2010/03/enable-debugtrace-level-logging-for.html) that details what to add to the tomcat logging.properties to enable it. 

I implemented the registered-user role.  It was a bit more of a hassle than I was expecting.  I learned that you can only declare a route in one security constraint.  So instead of giving administrator full access and restricting the user, I have to give access to each page that user can access to both roles and then add the rest of the pages for administrator in a later constraint.

I followed Paula's suggestion and added a seperate testing database.  It was simple enough.  All I had to do was create the database, copy the Table designs from the other database and then create a test resources directory in my project.  In that test resources directory I put a copy of the hibernate config xml file with the database url putting to the new database. 

One page I seem to keep visiting is this page on [Adding, Deleting and Moving Lines](https://www.jetbrains.com/idea/help/adding-deleting-and-moving-lines.html).  So I just think I will add it here so I don't have to search for it each time.

I decided to create seperate directories for jsps using CRUD terminology.  When initially implementing the user role for the class exercise I found I had to manually give permission to individual files for each security constraint.  Paula suggested restructuring the JSPs into directories based on their purpose.  It seems to have worked out well.

I have discovered that I cannot edit the url paths for the Tomee instance of my application when I move it.  I must delete the configuration and create a new one.

I was working on the expanded site's database design yesterday and noticed that most of the table had the same fields.  I am curious what the best practice is for an instance like this.  I was intending on having seperate tables/objects but if there is no difference outside of the table name?
