//package org.com.crnk.demo.repository;
//
//import io.crnk.core.queryspec.QuerySpec;
//import io.crnk.core.repository.ResourceRepositoryBase;
//import io.crnk.core.resource.list.ResourceList;
//import org.com.crnk.demo.model.Task;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class TaskResourceRepository extends ResourceRepositoryBase<Task, Long> {
//
//    @Autowired
//    private TaskRepository taskRepository;
//
//    public TaskResourceRepository() {
//
//        super(Task.class);
//
//    }
//
////    private final TaskRepository taskRepository;
////
////    @Autowired
////    public TaskResourceRepository(TaskRepository taskRepository) {
////        super(Task.class);
////        this.taskRepository = taskRepository;
////    }
//
//
//    @Override
//    public ResourceList<Task> findAll(QuerySpec querySpec) {
//        // Using JPA repository to fetch all tasks
//        return (ResourceList<Task> )taskRepository.findAll();
//    }
//    @Override
//    public <S extends Task> S save(S entity) {
//        return taskRepository.save(entity);
//    }
//
//    @Override
//    public void delete(Long id) {
//        taskRepository.deleteById(id);
//    }
//}


package org.com.crnk.demo.repository;

import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.resource.list.ResourceList;
import org.springframework.stereotype.Component;
import org.com.crnk.demo.model.Task;

import javax.annotation.PostConstruct;

@Component
public class TaskResourceRepository extends ResourceRepositoryBase<Task, Long> {

    private final TaskRepository taskRepository;

    public TaskResourceRepository(TaskRepository taskRepository) {
        super(Task.class);
        this.taskRepository = taskRepository;
    }


    @Override
    public <S extends Task> S save(S entity) {
        return taskRepository.save(entity);
    }

//    @Override
//    public void delete(Long id) {
//        taskRepository.deleteById(id);
//    }
//
//    @Override
//    public Task findOne(Long id, QuerySpec querySpec) {
//        return taskRepository.findById(id).orElse(null);
//    }

    @Override
    public ResourceList<Task> findAll(QuerySpec querySpec) {
        return querySpec.apply(taskRepository.findAll());
    }
}
