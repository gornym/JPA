package com.capgemini.wsb.persistence.entity;

import com.capgemini.wsb.persistence.enums.Specialization;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "DOCTOR")
public class DoctorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false)
	private String telephoneNumber;

	private String email;

	@Column(nullable = false)
	private String doctorNumber;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Specialization specialization;

	@ManyToOne
	@JoinColumn(name = "address_id", nullable = false)
	private AddressEntity address;

	@ManyToMany
	@JoinTable(
			name = "doctor_patient",
			joinColumns = @JoinColumn(name = "doctor_id"),
			inverseJoinColumns = @JoinColumn(name = "patient_id")
	)
	private Set<PatientEntity> patients = new HashSet<>();

	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
	private Set<VisitEntity> visits = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDoctorNumber() {
		return doctorNumber;
	}

	public void setDoctorNumber(String doctorNumber) {
		this.doctorNumber = doctorNumber;
	}

	public Specialization getSpecialization() {
		return specialization;
	}

	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}



	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JoinTable(
			name = "DOCTOR_TO_ADDRESS",
			joinColumns = @JoinColumn(name = "DOCTOR_ID"),
			inverseJoinColumns = @JoinColumn(name = "ADDRESS_ID")
	)
	private Collection<AddressEntity> addresses;

	public Collection<AddressEntity> getAddresses() {
		return addresses;
	}

	public void setAddresses(Collection<AddressEntity> addresses) { this.addresses = addresses; }


	public Collection<VisitEntity> getVisits() {
		return visits;
	}
}