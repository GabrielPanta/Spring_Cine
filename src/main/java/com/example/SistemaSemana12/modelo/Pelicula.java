
package com.example.SistemaSemana12.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Pelicula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pelicula")
	private Integer id;

	@NotBlank //anotación indica que el campo no puede ser nulo, no debe estar vacío ni contener solo espacios en blanco
	private String titulo;

	@NotBlank
        @Column(length = 255)
	private String sinopsis;

	@NotNull //fechaEstreno no puede ser nulo
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate fechaEstreno;

	@NotBlank
	private String youtubeTrailerId;

	private String rutaPortada;

	@NotEmpty // campo no puede estar vacío.
	@ManyToMany(fetch = FetchType.LAZY) //define una relación de tipo "muchos a muchos"
	@JoinTable(name = "genero_pelicula", joinColumns = @JoinColumn(name = "id_pelicula"), inverseJoinColumns = @JoinColumn(name = "id_genero"))
	private List<Genero> generos;

	@Transient //campo presente en la clase y su valor no se guardará en la base de datos
	private MultipartFile portada;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public LocalDate getFechaEstreno() {
		return fechaEstreno;
	}

	public void setFechaEstreno(LocalDate fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

	public String getYoutubeTrailerId() {
		return youtubeTrailerId;
	}

	public void setYoutubeTrailerId(String youtubeTrailerId) {
		this.youtubeTrailerId = youtubeTrailerId;
	}

	public String getRutaPortada() {
		return rutaPortada;
	}

	public void setRutaPortada(String rutaPortada) {
		this.rutaPortada = rutaPortada;
	}

	public List<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}

	public MultipartFile getPortada() {
		return portada;
	}

	public void setPortada(MultipartFile portada) {
		this.portada = portada;
	}

	public Pelicula() {
		super();
	}

	public Pelicula(Integer id, @NotBlank String titulo, @NotBlank String sinopsis, @NotNull LocalDate fechaEstreno,
			@NotBlank String youtubeTrailerId, String rutaPortada, @NotEmpty List<Genero> generos,
			MultipartFile portada) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.sinopsis = sinopsis;
		this.fechaEstreno = fechaEstreno;
		this.youtubeTrailerId = youtubeTrailerId;
		this.rutaPortada = rutaPortada;
		this.generos = generos;
		this.portada = portada;
	}

	public Pelicula(@NotBlank String titulo, @NotBlank String sinopsis, @NotNull LocalDate fechaEstreno,
			@NotBlank String youtubeTrailerId, String rutaPortada, @NotEmpty List<Genero> generos,
			MultipartFile portada) {
		super();
		this.titulo = titulo;
		this.sinopsis = sinopsis;
		this.fechaEstreno = fechaEstreno;
		this.youtubeTrailerId = youtubeTrailerId;
		this.rutaPortada = rutaPortada;
		this.generos = generos;
		this.portada = portada;
	}

}
