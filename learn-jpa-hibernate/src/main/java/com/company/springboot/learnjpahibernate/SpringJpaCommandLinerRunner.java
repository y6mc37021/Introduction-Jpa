package com.company.springboot.learnjpahibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.company.springboot.learnjpahibernate.course.springjpa.Course;
import com.company.springboot.learnjpahibernate.course.springjpa.CourseJpaRepository;

@Component
public class SpringJpaCommandLinerRunner implements CommandLineRunner{
	
	@Autowired
	private CourseJpaRepository courseJpaRepository;
	
	/*@Autowired
	private CourseJdbcRepository jdbcRepository;*/
	
	
	
	@Override
	public void run(String... args) throws Exception {
		
		courseJpaRepository.insert(new Course(1,"AZUR","MICROSOFT"));
		courseJpaRepository.insert(new Course(2,"GCP","GOOGLE"));
		courseJpaRepository.insert(new Course(3,"AWS","AMAZON"));
		
		courseJpaRepository.deleteById(1l);
		
		System.out.println(courseJpaRepository.findById(2));
	}
	
	
	/*@Override
	public void run(String... args) throws Exception {
		
		jdbcRepository.insert(new Course(1,"AZUR","MICROSOFT"));
		jdbcRepository.insert(new Course(2,"GCP","GOOGLE"));
		jdbcRepository.insert(new Course(3,"AWS","AMAZON"));
		
		jdbcRepository.deleteById(1l);
		
		System.out.println(jdbcRepository.findById(3));
	}*/
	
	
	

}
