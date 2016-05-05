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

## Week 6

3/1/2016

Completed:
    Implemented Gradle

---

After the multiple times that I have moved my project and the inconveniences that it has caused, I have decided after a discussion with Paula that I need to implement a dependency manager such as Maven.  I have decided to research Maven and its competitors this week.  After my research has been done I will try to implement my choice.  I decided to make this a priority because I am sure to move things again and I would prefer that they do not break when I do.

The other item I want to make a priority this week is the database elements.  I would like to create all the table I think I need at this time for the project and work on the DAOs needed for them.  I would like to make at the very least substantial progress towards the DAOs (with testing) by the end of the week.

This means that I am pushing deployment to OpenShift off again.  I did not have much trouble deploying the sample application and have experienced deploying various things before.  I also would like to wait until I have more of the application done before deploying.  

After talking things over with Matt on Slack, I decided that Gradle was the way I wanted to go.  Well, I sent 9 hours trying to implement Gradle to no avail.  The major issue I found was my project wasn't setup the way a Gradle project is expecting.  It seems that Gradle expects everything in the src directory and then seperated from there.  Code goes in src/main/java with resources in src/main/resources.  Tests seem to go into src/main/test.  It has not been a pleasant experience at all.

I thought I found a way around the namespace issue only for none of my dependencies to load.  It was an incredibly frustating experience.  Gradle seems like it might be an option with new projects but adding it to trying to add it to my project has not been simple.

I think I will try Maven tomorrow.  Considering what a pain it was to reset my project to its state before trying to add Gradle, I will try and be sure of the exact steps needed before proceeding with Maven.

I decided to try again with Gradle and finally got it!  I had to reorganize my project into the src directory.  I got hung up for quite a while dealing with a HibernateMappingException.  I googled and found nothing that worked.  I finally realized while looking at the hibernate.cfg.xml file that I should probably include MySQL into the dependencies.  And voila, the tests pass again.  Implementing gradle has been a long and frustating process.  I struggled with IntelliJ trying to include a Gradle module or restructure the namespaces.  When I got past those issues then their was some issues with different versions of the jar files then I was used to.  For instance, I specified a newer version of Log4J which changes the namespace and utilizes LogManager instead of Logger.  There is still work to do, I need to interface with Tomee with Gradle and clean up jars that I no longer need.  But at the very least, progress has been made.

## Week 7

03/03/2016

Completed:
    Updating Database Design Document

03/09/2016

Completed:
    Creating Database Tables

This week I have been spending a lot of working on my presentation for class.  I initially wanted to give a broad overview of the new stuff in Java 8.  After putting some work in and discussing things with Paula, I decided to cover Lambdas and the related concepts with this presentation.  With the next presentation, I could possibly cover Optionals and Streams.  I was positive I did not want to cover Lambdas and Streams in the same short presentation.  I couldn't see a way to cover two topics of that scale adequately in 10-15 minutes.

I was able to create most of the Database Tables today.  I was using the IntelliJ Database tools.  I ended up having trouble with Foreign Keys with the tool.  With Paula's help, I was able to fix it.  Next time I think I will use the Terminal interface for MySQL.

## Week 8

03/09/2016

Completed:
    Figured out how to use logic to set page titles

I was sick over Spring Break, so unfortunately I didn't get much done as far as my project goes.  After I recovered, I spent some time working on the team project.

## Week 9

03/23/2016

Completed:
    Deployed to OpenShift

03/27/2016

Completed:
    Created last test database table needed

03/28/2016

Completed:
    Fixing Primary Key database issue
    Researched using an abstract DAO class

03/29/2016

Completed:
  Implemented abstract DAO class
  Converted UserDAO to use Abstract DAO
  Created LanguageDAO that implements Abstract DAO

03/30/2016

Completed:
   Deployed to openshift with authorization

With the help from Matt and Paula I was able to deploy to Openshift.  It was heavily complicated by my Gradle implementation.  I was having trouble getting a good war for deployment.  It was an issue that I believe was created by adding Gradle in the middle of the project.  Another issue that arose was Gradle not finding the IntelliJ instance of Tomee.  I had to point Gradle to the main instance that runs on my machine.  I had no idea that there was a difference.  I found out the hard way.

I started work on my Language DAO but ran into a number of issues.  First, I missed making every Primary Key Auto-Increment which might I had to go and delete all my foreign keys to make the change.  Hopefully, I remember all my foreign keys when I readded them.

The second issue that arose concerned my DAOs.  They felt extremely dirty.  Every new DAO I create it seems that I am copying and pasting the entirety of the previous DAO.  I talked to Paula to see if there was a way to abstract that logic and she suggested looking at abstract classes.  It took a while but I think I am making some progress.  If this ends up working correctly, I will be writing a lot less code in the future.

I converted my UserDAO from the seperate interface/implementation pattern to one that uses the AbstractDAO pattern.  I had an issue debugging findById tests.  It ended up being a problem where I copied the implementation from the LanguageDao, which was my initial guinea pig.  It was a facepalm moment as it took quite some time to debug.  After setting up the LanguageDao and converting the UserDao, I am liking the new pattern so far.  I find it much cleaner and a lot less code to have to write.

I had quite the time porting my MySQL databases to the OpenShift.  I tried DDL dumping the commands into PHPMyAdmin.  That didn't work at all. Finally, I gave up and sshed into the OpenShift instance.  After that I had no problems whatsoever.

I finally was able to deploy to Openshift with Authorization working.  It turns out I needed to add a Realm to the server.xml.  It wasn't that simple as it required adding a Context to the Host section of the xml file.  In addition, I had to change my war file to be a subdomain of Root.  I was still struggling and it turns out I lacked a mysql connector jar in my tomcat server instance.  I thought since I included it in my build.gradle I was good to go.  After that the authorization was finally working.

## Week 10

Worked mostly on Team project.

## Week 11

04/06/16

Completed: 
    - fixed broken log4j configuration

I started on the languages servlet and started debugging an log4j issue.  It seems that when I added Gradle I changed log4j versions from 1.2 to 2.5.  That version change seemed to break log4j and I just didn't notice.  I know I can revert back to version 1.x but I want to get 2.x working.  

After some research, I found that I need a new log4j configuration file.  the configurations for version 2 is slightly different from version 1.  I added the new file and it still is not functioning.  I found out it was because I needed to different the log4j.properties from the 1.x version.  Now it works as expected.

## Week 12

04/14/16

Completed:
    Connected languages servlet

04/16/16

Completed:
    Got Show Language servlet working

04/19/16

Completed:
    Got add Languages servlet working

I was finally about to display a list of languages in the languages jsp.  I was having quite the trouble and found it was a mysql issue.  The IntelliJ version was not adding records when I tried using the Database console view.  I was able to add one using my Terminal instance.

I still extremely dislike the routes given for each jsp.  I spent some time researching alternatives and may look at web frameworks a bit more in depth at some point in the next week or two.  My limited research has lead me to believe that Spring MVC, Play, or Spark may provide me with the routing mechanism I want.  Another option was uncovered after talking with Paula: To throw a lot of complications in the web.xml file.  I could set the jsp path as best I could staticly in the project and then configure the Realm accordingly or I could look into servlet url-mapping which may also hold a solution to my problems.

## Week 13

04/20/16

Completed:
    MATC Challenge Course

04/26/16

Completed:
    Delete Servlet for Languages
    Refactored Logic dealing with URL Special Characters

I was able to complete the challenge course.  I was a bit surprised.  I learned that it was better to focus on the next step.  There was no point in looking at the goal as it was not useful to what I needed to do in this instance.  I took a couple bumps and got a little sunburnt but otherwise a good day.  

I ended up spending most of my time this week working on one of my iOS projects.  Eric announced the presentation date for those and it does not bode well for themy Java project.  It is two days before and with the nature of the event, I feel I will have to spend the majority of the weekend before on those two projects.  I have decided my solution to this problem is to move my Java presentation forward a week.  My hope is that it will motivate me to get as much done for the presentation as possible over the next week.

I finally got the Languages delete servlet for hooked up and in the process was talking to Michael Tackes about my parameter special character issue.  He led me down the path to a much better (in my eyes) solution.  Instead, of requiring logic in the jsp & servlet class, all I need to do is add 
```
<c:url value="language" var="url">
    <c:param name="name" value="${language.name}" />
</c:url>
```
and it takes care of the rest!

## Week 14

04/28/16

Completed:
    Fixed Path issue I was facing

04/29/16

Completed:
    Types DAO

04/30/16

Completed:
    Created New Concepts servlet

05/01/16

Completed:
    Created New Terms servlet
    Created Topic Servlet Utility Class
    Hooked up Languages page to contain all Concepts and Terms
    Created Show Algorithms Servlet
    Figured out url issue when forwarding

05/02/16

Completed:
    Created New Algorithms Servlet

05/03/16

Completed:
    Show Algorithms Servlet
    Fixed failing tests

05/04/16

Completed:
    Update Algorithm Servlet
    Delete Algorithm Servlet
    Implement Web Service

I finally figured out what was going on in my paths.  In the JSPs I was going to languages instead of /languages and so on. :facepalm:

I embarked in quite the debugging session trying hook up the TopicsDao.  It took quite a while and a lot of searching, but I found what was causing my TopicsDao from returning any topics.  I had the cascade property set to all for some of the many-to-many relationships.  That setting was causing me quite the problem.

I noticed that with the concepts and terms the only difference between the servlets end up being the type field.  I decided to pull it out into a utility class, where I could reuse methods as I see fit.

After much searching I was also able to solve my servlet forward issue.  After creating a Concept or Term, I would like to forward to the showLanguage page.  After a lot of searching I fould that I could create a doPost method that calls the doGet from that servlet.  That seemed to solve my issues.

Well, today was highly frustating and educational.  My hibernate started blowing up and I reacted to rashly, which only made it worse.  On top of that I didn't commit before I started debugging.  After toying around with an overly complicated solution that made the problem worse, I checked out to my last commit before I noticed the blow up.  I redid the code that caused the blowup and was able to pinpoint that it was the findById method in my DAO.  I rewrote that and my problem was solved and my tests pass again.

I completed the Update and Delete Algorithm actions.  They were not without their pains though.  I had Hibernate issues with each.  I had to replace the session.open with a check to see if an existing session is open first.  Otherwise, Hibernate throws a fit.

## Week 15

05/04/16

Completed:
    Gave Presentation
    Implemented Web service on show Algorithm page

I gave the presentation and only had a few hiccups.  I was able to fix the delete language bug.  I looking forward to see what feedback Paula provides in the code review.

I set myself up for quite a bit to do in the next week.  I plan on starting with finishing the topic implementation as that should only take a couple of hours at most.  Hopefully, I will be able to find some time over the next couple of days to do that while I focus on iOS.
