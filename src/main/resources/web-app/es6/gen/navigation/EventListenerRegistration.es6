'use strict';

class EventListenerRegistrationNavigation {

	static init() {
    	ACEController.registerListener('PublicCoursesReadEvent', NavigationView.renderPublicCourses);
    	ACEController.registerListener('PublicCoursesReadEvent', ContentView.renderPublicCourses);
    	ACEController.registerListener('PublicCoursesReadEvent', BreadcrumbsView.renderPublicCoursesBreadcrumbs);
    	ACEController.registerListener('PublicLessonsReadEvent', NavigationView.renderPublicLessons);
    	ACEController.registerListener('PublicLessonsReadEvent', ContentView.renderPublicLessons);
    	ACEController.registerListener('PublicLessonsReadEvent', BreadcrumbsView.renderPublicLessonsBreadcrumbs);
    	ACEController.registerListener('PublicTestsReadEvent', NavigationView.renderPublicTests);
    	ACEController.registerListener('PublicTestsReadEvent', ContentView.renderPublicTests);
    	ACEController.registerListener('PublicTestsReadEvent', BreadcrumbsView.renderPublicTestsBreadcrumbs);
    	ACEController.registerListener('PublicTestReadEvent', NavigationView.renderPublicTest);
    	ACEController.registerListener('PublicTestReadEvent', ContentView.renderPublicTest);
    	ACEController.registerListener('PublicTestReadEvent', BreadcrumbsView.renderPublicTestsBreadcrumbs);
    	ACEController.registerListener('PrivateCoursesReadEvent', NavigationView.renderPrivateCourses);
    	ACEController.registerListener('PrivateCoursesReadEvent', ContentView.renderPrivateCourses);
    	ACEController.registerListener('PrivateCoursesReadEvent', BreadcrumbsView.renderPrivateCoursesBreadcrumbs);
    	ACEController.registerListener('PrivateLessonsReadEvent', NavigationView.renderPrivateLessons);
    	ACEController.registerListener('PrivateLessonsReadEvent', ContentView.renderPrivateLessons);
    	ACEController.registerListener('PrivateLessonsReadEvent', BreadcrumbsView.renderPrivateLessonsBreadcrumbs);
    	ACEController.registerListener('PrivateTestsReadEvent', NavigationView.renderPrivateTests);
    	ACEController.registerListener('PrivateTestsReadEvent', ContentView.renderPrivateTests);
    	ACEController.registerListener('PrivateTestsReadEvent', BreadcrumbsView.renderPrivateTestsBreadcrumbs);
    	ACEController.registerListener('PrivateTestReadEvent', NavigationView.renderPrivateTest);
    	ACEController.registerListener('PrivateTestReadEvent', ContentView.renderPrivateTest);
    	ACEController.registerListener('PrivateTestReadEvent', BreadcrumbsView.renderPrivateTestsBreadcrumbs);
	}

}

/*       S.D.G.       */
