package pl.avd.sample.jpa.entitygraph;



public class Oracle10gDialect extends org.hibernate.dialect.Oracle10gDialect {
  
  @Override
  public String getCrossJoinSeparator() {
    return " cross join ";
  }
}
