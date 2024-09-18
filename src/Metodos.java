
import java.io.File;
import java.io.IOException;

public class Metodos {

    /*  1) metodo eDirectorio(cadea)
        que detecte se unha cadea dada corresponde a un directorio .
        cadea  debe ser un String que contena a ruta absoluta do directorio.
        imprimirase 'e un directorio' ou 'non e un directorio'*/
    public static void esDirectorio(String cadena) {
        File file = new File(cadena);
        if (file.isDirectory()) {
            System.out.println("Es un directorio");
        } else {
            System.out.println("No es un directorio");
        }
    }

    /* 2) metodo eFicheiro(cadea )
        que comprobe se unha cadea  dada corresponde a  un ficheiro.
        cadea  debe ser un String que contena a ruta absoluta do directorio
        imprimirase 'e un ficheiro' ou 'non e un ficheiro'
    /*
     */
    public static void esArchivo(String cadena) {
        File file = new File(cadena);
        if (file.isFile()) {
            System.out.println("Es un archivo");
        } else {
            System.out.println("No es un archivo");
        }
    }

    /* 3) metodo creaDirectorio(String)
    debe crear un  directorio  a partir da ruta absoluta do mesmo que
    se lle debe pasar coma un String . So debe crearse  dito directorio
     cando non exista previamente
     */
    public static void crearDirectorio(String dirName) {
        File dir = new File(dirName);
        if (!dir.exists()) {
            if (dir.mkdirs()) {
                System.out.println("Directorio creado: " + dirName);
            } else {
                System.out.println("Error al crear el directorio");
            }
        } else {
            System.out.println("El directorio ya existe");
        }
    }

        /* 4) metodo  creaFicheiro(dirName, fileName);
        debe crear un  ficheiro nunha ruta absoluta que exista previamente,
        estos dous valores deben pasarse ao metodo como valores String.
        So debe crearse  dito ficheiro en dita ruta  cando non exista previamente
        */
    public static void crearArchivo(String dirName, String fileName) {
        File file = new File(dirName, fileName);
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("Archivo creado: " + fileName);
                } else {
                    System.out.println("Error al crear el archivo");
                }
            } catch (IOException e) {
                System.out.println("Excepcion: " + e.getMessage());
            }
        } else {
            System.out.println("El archivo ya existe");
        }
    }

        /* 5) metodo  modoAcceso (dirName, fileName);
        dado a ruta absoluta  e nome dun archivo ,este metodo debe imprimir a palabra:
        "escritura si" se se pode escribir nel
        "escritura non" se non se pode escribir nel
        "lectura si" se se pode ler nel
        "lectura non" se non se pode ler nel
         */
    public static void modoAcceso(String dirName, String fileName) {
        File file = new File(dirName, fileName);
        if (file.exists()) {
            if (file.canWrite()) {
                System.out.println("Escritura si");
            } else {
                System.out.println("Escritura no");
            }
            if (file.canRead()) {
                System.out.println("Lectura si");
            } else{
                System.out.println("Lectura non");
            }
            //otra manera de hacerlo:
            /*
            System.out.println(file.canWrite() ? "Escritura si" : "Escritura no");
            System.out.println(file.canRead() ? "Lectura si" : "Lectura non");
            */
        } else {
            System.out.println("El archivo no existe");
        }
    }

        /* 6) metodo   calculaLonxitude(dirName, fileName)
        dado a ruta absoluta  e nome dun archivo ,
        este metodo  debe : imprimir a lonxitude en bytes do mesmo
        */
    public static void calcularLongitud(String dirName, String fileName) {
        File file = new File(dirName, fileName);
        if (file.exists()) {
            System.out.println("Longitud en bytes: " + file.length());
        } else {
            System.out.println("El archivo no existe");
        }
    }

        /*7) metodo  mLectura (dirName, fileName)
        dado a ruta absoluta  e nome dun archivo ,este metodo  debe facer
         o arquivo de so lectura
        */
    public static void mLectura(String dirName, String fileName) {
        File file = new File(dirName, fileName);
        if (file.exists()) {
            if (file.setReadOnly()) {
                System.out.println("El archivo ahora es de solo lectura");
            } else {
                System.out.println("No se pudo cambiar a solo lectura");
            }
        } else {
            System.out.println("El archivo no existe");
        }
    }

        /* 8) metodo  mEscritura (dirName, fileName)
        dado a ruta e nome dun archivo ,
        este metodo debe facer posible escribir no arquivoo.
         */
    public static void mEscritura(String dirName, String fileName) {
        File file = new File(dirName, fileName);
        if (file.exists()) {
            if (file.setWritable(true)) {
                System.out.println("El archivo puede ser escrito");
            } else {
                System.out.println("No se pudo cambiar a escritura");
            }
        } else {
            System.out.println("El archivo no existe");
        }
    }

        /* 9) metodo  borraFicheiro(dirName, fileName)
        dado a ruta e nome dun archivo debe eliminalo se e que existe
        senon lanzar a mensaxe ficheiro inexistente
        */
    public static void borraFicheiro(String dirName, String fileName) {
        File file = new File(dirName, fileName);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("Archivo borrado: " + fileName);
            } else {
                System.out.println("No se pudo borrar el archivo");
            }
        } else {
            System.out.println("Archivo inexistente");
        }
    }

        /* 10) metodo  borraDirectorio(dirName)
        dada una ruta debe eliminala se e que existe senon lanzar
         a mensaxe 'ruta inexistente ou con descencencia'
         */
    public static void borrarDirectorio(String dirName) {
        File dir = new File(dirName);
        if (dir.exists()) {
            if (dir.delete()) {
                System.out.println("Directorio borrado: " + dirName);
            } else {
                System.out.println("Non se pudo borrar el directorio (pode ser que teña descendencia)");
            }
        } else {
            System.out.println("Ruta inexistente");
        }
    }

        /* 11) metodo mContido(dirName)
        que amose arquivos e directorios de primeiro nivel dunha ruta absoluta dada
        */
    public static void mostrarContenido(String dirName) {
        File dir = new File(dirName);
        if (dir.exists() && dir.isDirectory()) {
            String[] contenido = dir.list();
            if (contenido != null) {
                for (String nombre : contenido) {
                    System.out.println(nombre);
                }
            } else {
                System.out.println("Directorio vacio");
            }
        } else {
            System.out.println("No es un directorio valido");
        }
    }

        /* 12)(Opcional) metodo recur(File)
         que amose arquivos e subdirectorios do directorio que se lle pase como obxecto File.
         */
    public static void amosarRecursivo(File dir) {
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    System.out.println(file.getAbsolutePath());
                    if (file.isDirectory()) {
                        amosarRecursivo(file);  // <- Recursividad
                    }
                }
            }
        }
    }
}
