package pl.avd.sample.jpa.entitygraph;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;

@Entity
@NamedEntityGraph(
    name = Car.GRAPH_FETCH_ALL, 
    attributeNodes = {
        @NamedAttributeNode("manufacture"),
        @NamedAttributeNode("owner")
    }
)
public class Car {
  
  public static final String GRAPH_FETCH_ALL = "Car.graphWithManufactureAndOwner";

  @Id
  private String vin;
  
  private String name;
  
  @ManyToOne
  private Manufacture manufacture;
  
  @ManyToOne
  private Owner owner;
  
  public String getVin() {
    return vin;
  }
  
  public void setVin(String vin) {
    this.vin = vin;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public Manufacture getManufacture() {
    return manufacture;
  }
  
  public void setManufacture(Manufacture manufacture) {
    this.manufacture = manufacture;
  }
  
  public Owner getOwner() {
    return owner;
  }
  
  public void setOwner(Owner owner) {
    this.owner = owner;
  }
}
