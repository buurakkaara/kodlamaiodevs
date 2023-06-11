package kodlama.io.devs.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.devs.entities.Technology;

public interface TechnologyRepository extends JpaRepository<Technology, Integer>{

	boolean existsByName(String name);
	
}
