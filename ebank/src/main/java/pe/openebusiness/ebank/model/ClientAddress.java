package pe.openebusiness.ebank.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENT_ADDRESS")
public class ClientAddress implements Serializable {
	
	@Id
	@GeneratedValue(generator = "client_address_seq")
	@SequenceGenerator(name = "client_address_seq", sequenceName = "CLIENT_ADDRESS_SEQ", allocationSize = 1	)
	@Column(name = "address_id")
	private Integer address_id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "client_id", nullable = false)
	private Client client;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "address_type_id", nullable = false)
	private AddressType addressType;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "housing_type_id")
	private HousingType housingType;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "zone_type_id")
	private ZoneType zoneType;
	
	@Column(name = "zone_name", nullable = true)
	private String zone_name;
	
	@Column(name = "block", nullable = true)
	private String block;
	
	@Column(name = "lot", nullable = true)
	private String lot;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "road_type_id")
	private RoadType roadType;
	
	@Column(name = "road_name", nullable = true)
	private String road_name;
	
	@Column(name = "road_number", nullable = true)
	private String road_number;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "group_type_id")
	private AddressGroupType groupType;
	
	@Column(name = "group_name", nullable = true)
	private String group_name;
	
	@Column(name = "group_number", nullable = true)
	private String group_number;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sector_type_id")
	private SectorType sectorType;
	
	@Column(name = "sector_name", nullable = true)
	private String sector_name;
	
	@Column(name = "reference", nullable = true, length = 200)
	private String reference;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ubigeo_id")
	private Ubigeo ubigeo;

	public Integer getAddress_id() {
		return address_id;
	}

	public void setAddress_id(Integer address_id) {
		this.address_id = address_id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getZone_name() {
		return zone_name;
	}

	public void setZone_name(String zone_name) {
		this.zone_name = zone_name;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getLot() {
		return lot;
	}

	public void setLot(String lot) {
		this.lot = lot;
	}

	public String getRoad_name() {
		return road_name;
	}

	public void setRoad_name(String road_name) {
		this.road_name = road_name;
	}

	public String getRoad_number() {
		return road_number;
	}

	public void setRoad_number(String road_number) {
		this.road_number = road_number;
	}

	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}

	public String getGroup_number() {
		return group_number;
	}

	public void setGroup_number(String group_number) {
		this.group_number = group_number;
	}

	public String getSector_name() {
		return sector_name;
	}

	public void setSector_name(String sector_name) {
		this.sector_name = sector_name;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public AddressType getAddressType() {
		return addressType;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}

	public HousingType getHousingType() {
		return housingType;
	}

	public void setHousingType(HousingType housingType) {
		this.housingType = housingType;
	}

	public ZoneType getZoneType() {
		return zoneType;
	}

	public void setZoneType(ZoneType zoneType) {
		this.zoneType = zoneType;
	}

	public RoadType getRoadType() {
		return roadType;
	}

	public void setRoadType(RoadType roadType) {
		this.roadType = roadType;
	}

	public AddressGroupType getGroupType() {
		return groupType;
	}

	public void setGroupType(AddressGroupType groupType) {
		this.groupType = groupType;
	}

	public SectorType getSectorType() {
		return sectorType;
	}

	public void setSectorType(SectorType sectorType) {
		this.sectorType = sectorType;
	}

	public Ubigeo getUbigeo() {
		return ubigeo;
	}

	public void setUbigeo(Ubigeo ubigeo) {
		this.ubigeo = ubigeo;
	}
	
}

