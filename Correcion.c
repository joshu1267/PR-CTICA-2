
void main() {
enum semana_laboral {LUNES=1, MARTES=2, MIERCOLES=3, JUEVES=4, VIERNES=5};
int dia = 1;
scanf("%i", &dia);
for (int i = 1; i <= VIERNES; i++){
	printf("El día de la semana es: %i \n", i);
	if ((i % 2) != 0){
		printf("Hoy es un gran día para Teoría de la Programación: \n", dia);
	}
	if (dia == i){
		break;
	}
}
}