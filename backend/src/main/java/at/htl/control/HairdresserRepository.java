package at.htl.control;

import at.htl.entity.Hairdresser;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class HairdresserRepository implements PanacheRepository<Hairdresser> {

    @Transactional
    public Hairdresser save(Hairdresser hairdresser) {
        return getEntityManager().merge(hairdresser);
    }

    public List<Hairdresser> findAllHairdresser(){
        var query = getEntityManager().createQuery("Select h from Hairdresser h", Hairdresser.class);
        return query.getResultList();
    }

    public Hairdresser findById(long id){
        return find("id", id).firstResult();
    }

}
