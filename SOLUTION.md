# SOLUTION
**Adriana Maria Velásquez Medina**

 # RESUMEN
## Pruebas de Parcial I y Parcial II con bonus integradas en un mismo proyecto pasan con éxito.
![image](https://user-images.githubusercontent.com/79488147/116016029-fb399d80-a600-11eb-89c4-2d0f507050a8.png)

## SONARQUBE
![image](https://user-images.githubusercontent.com/79488147/116016248-af3b2880-a601-11eb-9e31-d9137ab06970.png)

![image](https://user-images.githubusercontent.com/79488147/116016267-bc581780-a601-11eb-9244-922ba90de162.png)

![image](https://user-images.githubusercontent.com/79488147/116016296-cd088d80-a601-11eb-9d8a-d465574ae15f.png)

![image](https://user-images.githubusercontent.com/79488147/116016313-e1e52100-a601-11eb-8cbc-9d9373f3a55f.png)


---
---
# PARCIAL II

## **1. Implementando**

![image](https://user-images.githubusercontent.com/79488147/115906572-4dc26080-a42d-11eb-9e1a-3fdaff52ea81.png)

## **2. Diseñando**

StudentSyntheziser()

![image](https://user-images.githubusercontent.com/79488147/116018099-e7913580-a606-11eb-862e-ffd0692d10da.png)


ExecutiveSyntheziser()

![image](https://user-images.githubusercontent.com/79488147/116018066-d47e6580-a606-11eb-9bbc-fbb75ab2e1ac.png)

Diagrama de Clases

![image](https://user-images.githubusercontent.com/79488147/116020165-60928c00-a60b-11eb-927a-7e19986c6afd.png)


## **3. Extendiendo**

**

![image](https://user-images.githubusercontent.com/79488147/116020909-cd5a5600-a60c-11eb-9f77-bac4c7aa0ad4.png)


**De los diseños resultantes del punto I y II, ¿Qué debe cambiar? ¿Qué no debe cambiar?. Justifique su respuesta.**


Cambia el diseño del punto 1 porque la duración de una actividad ahora no es solo sus steps y sus questions si no que ahora se calcula la duración de todas sus dependencias y se le suma la duración de la actividad. 

Del punto 2 no habría que cambiar nada porque el método getDuration() de actividad ha cambiado para incluir la duración de las dependencias. Aunque el metodo se comporte diferente, el sintetizador llama a el método get activities duration que llama a la duración de una actividad.

**Teniendo en cuenta los cambios necesarios ¿Que fue bueno y que fue malo de su diseño?**

Principalmente haría las cosas de otra manera para simplificar el codigo.





## **4. Conceptos**
---

1. ¿Cuáles son las acciones los tres momentos importantes de las excepciones? ¿Cuál es el objetivo de cada una? ¿Cómo se implementa en Java cada acción?.

    Son 3 los momentos clace de las excepciones:

    1. LANZAR

    `Throw: ` Algo ocurrió y se quiere informar de dicho suceso. Se lanza una excepción.

    Para implementarlo se utiliza la palabra clave throw y se pone una condicione en la cual se la lanzara la excepción


    2. PROPAGAR

    `Propagate:` Propagar una excepcion significa que hay un metodo que sabe que puede surgir una excepcion pero no puede controlar esa excepción para hacer algo con ella.Da la responsabilidad a alguien para arreglar lo que falló.

    Para implementarlo se utiliza la palabra clave throws  


    3. CAPTURAR

    `Catch:` Se hace resonsable del falló.

    Para implementarlo se utiliza la palabra clave catch. Habrá tantos catchs como excepciones que el método lanza. A su vez suele acompañarse con un try donde se pone todo el codigo que posiblemente pueda arrojar una excepción

 
    

---

2. ¿Qué es sobre-escritura de métodos? ¿Por qué aplicarla? ¿Cómo impedir que se sobre-escriba un método?.

    La sobre-escritura de métodos en java es utilizar utilizar métodos previamente expuestos en nuestro codigo en varios lugares del mismo dónde se requiera una implementación distinta. Se aplica para hacer nuestros proyectos en java más conciso de esta forma un mismo método puede tomar distintas formas depende de lo que se requiera y no hay necesidad de ser redundantes. Para impedir que se sobre escriba un método se pueden incluir la palabra clave final.

## **5. Bonus**
**ISynthesizerTest**
![image](https://user-images.githubusercontent.com/79488147/116015669-b2cdb000-a5ff-11eb-8e71-fdd60214b69b.png)

* Summarize(ExecutiveSyntheziser) displays resume as follows:
![image](https://user-images.githubusercontent.com/79488147/116015722-ef99a700-a5ff-11eb-9f9d-36289ca31cda.png)

* summarize(StudentSyntheziser) displays resume as follows:
![image](https://user-images.githubusercontent.com/79488147/116015816-456e4f00-a600-11eb-8a4b-3f18707483ab.png)

*nota:* Se agregaron dos excepciones a Sabana Research Exception para casos de estudiantes.


---
---

# PARCIAL I
(Lo unico que hacía falta era el bono)

## **1. Memoria**

![image](https://user-images.githubusercontent.com/79488147/110189115-05eb6980-7dec-11eb-94da-02989fd0baf2.png)


## **2. Código**

![image](https://user-images.githubusercontent.com/79488147/116016723-2cb36880-a603-11eb-8d32-536d94ca8be2.png)


## **3. Diseño**
![image](https://user-images.githubusercontent.com/79488147/111008995-6b95a380-8360-11eb-87a7-7d96d763651c.png)

## **4. Conceptos**

## Encapsulamiento

El encapsulamiento define los mecanismos que unen el estado y los comportamientos de un objeto en una unidad lógica única. Se define el nivel de acceso de una variable.

**Ventajas:** Evita que agentes externos interactuen directamente con nuestras variables

## Ocultación información 

**¿Qué es ocultación de información?**

En java la ocultación de información quiere decir que los métodos y atributos privados solo serán accesibles desde la misma clase. 

**¿Por qué aplicarla?**

Se aplica ya que no es necesario mostrar como esta hecho un método afuera de la misma clase, evita que interactuen directamente con nuestras variables.  

**Cómo se implementa en Java**

Se implementa en java al almacenar toda una unidad lógica en un solo componente dentro de una clase. Se utiliza un modificador de acceso privado por ejemplo.

## **5. Bonus**

(Como se muestra en código las pruebas pasan).

![image](https://user-images.githubusercontent.com/79488147/116016777-4a80cd80-a603-11eb-8187-993faaa37271.png)



