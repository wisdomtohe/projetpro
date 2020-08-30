package com.ipnetinstitute.csc394.backend.controller;

import com.ipnetinstitute.csc394.backend.dao.BaseEntityRepository;
import com.ipnetinstitute.csc394.backend.entity.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class BaseController implements InitializingBean {
	@Autowired
	private BaseEntityRepository<User> userRepo;
	@Autowired
	private BaseEntityRepository<Teacher> teacherRepo;

	@Autowired
	private BaseEntityRepository<Student> studentRepo;

	@Autowired
	private BaseEntityRepository<Survey> surveyRepo;

	@Autowired
	private BaseEntityRepository<Response> responseRepo;
	
	@Autowired
	private BaseEntityRepository<Question> questionRepo;

	@Autowired
	private BaseEntityRepository<Course> courseRepo;
// controller verifier
// deuxieme test
	@Autowired
	private BaseEntityRepository<Classe> classeRepo;

//	 @Autowired
//	 private BaseEntityRepository<Role> roleRepo;

	@Autowired
	private BaseEntityRepository<Filiere> filiereRepo;

	private static Map<String, BaseEntityRepository> repos;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/get/{entity}/{id}", method = RequestMethod.GET)
	public <T extends BaseEntity> Optional<T> getById(@PathVariable("entity") final String entity,
			@PathVariable("id") final Long id) throws ClassNotFoundException {
		Optional<T> result = null;
		try {
			result = (Optional<T>) repos.get(entity).findById(id);
		} catch (final Exception e) {
			e.printStackTrace();
		} finally {
			return result;
		}
	}

	@RequestMapping(value = "/getAll/{entity}", method = RequestMethod.GET)
	public List getAll(@PathVariable("entity") final String entity) throws ClassNotFoundException {
		List result = new ArrayList();
		try {
			result = (List) repos.get(entity).findAll();
		} catch (final Exception e) {
			e.printStackTrace();
		} finally {
			return result;
		}
	}

	@RequestMapping(value = "/count/{entity}", method = RequestMethod.GET)
	public long count(@PathVariable("entity") final String entity) throws ClassNotFoundException {
		long result = 0;
		try {
			result = repos.get(entity).count();
		} catch (final Exception e) {
			e.printStackTrace();
		} finally {
			return result;
		}
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/save/{entity}", method = RequestMethod.POST)
	public <T extends BaseEntity> T save(@PathVariable("entity") final String entity, @RequestBody final BaseEntity be)
			throws ClassNotFoundException {
		T result = (T) be;
		try {
			if (be.getId() == null) {
				be.setCreateDateTime(new Date());
				System.out.println(be.getCreateDateTime());
				be.setModDateTime(new Date());
			} else {
				be.setModDateTime(new Date());
			}
			result = (T) repos.get(entity).save(be);

		} catch (final Exception e) {
			result.setError(e.getMessage());
			e.printStackTrace();
		} finally {
			return result;
		}
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/delete/{entity}", method = RequestMethod.POST)
	public String delete(@PathVariable("entity") final String entity, @RequestBody final BaseEntity be)
			throws ClassNotFoundException {
		try {
			repos.get(entity).delete(be);
			return "Success";
		} catch (final Exception e) {
			return "Error: " + e.getMessage();
		}
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "delete/{entity}/{id}", method = RequestMethod.GET)
	public String deleteById(@PathVariable("entity") final String entity, @PathVariable("id") final Long id)
			throws ClassNotFoundException {
		try {
			repos.get(entity).deleteById(id);
			return "Success";
		} catch (final Exception e) {
			return "Error: " + e.getMessage();
		}
	}



	@Override
	public void afterPropertiesSet() throws Exception {
		repos = new HashMap<String, BaseEntityRepository>();
		repos.put("user", userRepo);
		repos.put("teacher", teacherRepo);
		repos.put("student", studentRepo);
		repos.put("question", questionRepo);
		repos.put("filiere", filiereRepo);
		repos.put("course", courseRepo);
		repos.put("classe", classeRepo);
		repos.put("survey", surveyRepo);
		repos.put("question", questionRepo);
		repos.put("response", responseRepo);


	}
}
