package pl.avd.sample.jpa.entitygraph;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class EntityGraphOrderByTest {
  
  private static EntityManagerFactory hsqldbFactory = Persistence.createEntityManagerFactory("hsqldbManager");
  private static EntityManagerFactory oracleFactory = Persistence.createEntityManagerFactory("oracleManager");
  
  @Test
  public void hsqldbTest() {
    doGraphTest(hsqldbFactory.createEntityManager());
  }
  
  @Test
  public void oracleTest() {
    doGraphTest(oracleFactory.createEntityManager());
  }
  
  @Test
  public void hsqldbOrderByTest() {
    doGraphOrderByTest(hsqldbFactory.createEntityManager());
  }
  
  @Test
  public void oracleOrderByTest() {
    doGraphOrderByTest(oracleFactory.createEntityManager());
  }
  
  private void doGraphTest(EntityManager em) {
    EntityGraph<?> graph = em.getEntityGraph(Car.GRAPH_FETCH_ALL);
    
    em.createQuery("select c from Car c", Car.class)
        .setHint("javax.persistence.fetchgraph", graph)
        .getResultList();
  }
  
  private void doGraphOrderByTest(EntityManager em) {
    EntityGraph<?> graph = em.getEntityGraph(Car.GRAPH_FETCH_ALL);
    
    em.createQuery("select c from Car c order by c.manufacture.name", Car.class)
        .setHint("javax.persistence.fetchgraph", graph)
        .getResultList();
  }
}
