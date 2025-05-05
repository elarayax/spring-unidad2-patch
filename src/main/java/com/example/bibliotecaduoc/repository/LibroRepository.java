package com.example.bibliotecaduoc.repository;

import java.util.ArrayList;
import java.util.List;
import com.example.bibliotecaduoc.model.Libro;

import org.springframework.stereotype.Repository;

@Repository
public class LibroRepository {

    private List<Libro> listaLibros = new ArrayList<>();

    public List<Libro> obtenerLibros(){
        return listaLibros;
    }

    public Libro buscarPorId(int id){
        for(Libro libro : listaLibros){
            if(libro.getId() == id){
                return libro;
            }
        }
        return null;
    }

    public Libro buscarPorIsb(String isbn){
        for(Libro libro : listaLibros){
            if(libro.getIsbn().equals(isbn)){
                return libro;
            }
        }
        return null;
    }

    public Libro guardar(Libro lib){
        listaLibros.add(lib);
        return lib;
    }

    public Libro actualizar(Libro lib){
        for (int i = 0;i < listaLibros.size(); i++){
            if(listaLibros.get(i).getId() == lib.getId()){
                listaLibros.set(i, lib);
                return lib;
            }
        }
        return null;
    }

    public Libro editar(int id,Libro lib){
        for(int i = 0; i <= listaLibros.size(); i++){
            if(listaLibros.get(i).getId() == id){
                Libro auxLibro = listaLibros.get(i);
                if(lib.getIsbn() != null){
                    auxLibro.setIsbn(lib.getIsbn());
                }

                if(lib.getTitulo() != null){
                    auxLibro.setTitulo(lib.getTitulo());
                }

                if(lib.getEditorial() != null){
                    auxLibro.setEditorial(lib.getEditorial());
                }

                if(lib.getFechaPublicacion() != 0){
                    auxLibro.setFechaPublicacion(lib.getFechaPublicacion());
                }

                if(lib.getAutor() != null){
                    auxLibro.setAutor(lib.getAutor());
                }

                listaLibros.set(i, auxLibro);
                return auxLibro;
            }
        }
        return null;
    }

    public void eliminar( int id){
        Libro libro = buscarPorId(id);
        if (libro != null){
            listaLibros.remove(libro);
        }
    }

}
