package p1pds;

import java.io.BufferedOutputStream;
import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.crypto.KeyGeneratorSpi;
import javax.imageio.plugins.tiff.ExifGPSTagSet;

import java.lang.*;
public class WSSsolver {
	static int MAX=40;
	

	static char [][] array=new char[MAX][MAX];
	static char [][] arrayfinal=new char[MAX][MAX];
	static ArrayList<String> coretor = new ArrayList<String>(); // Create an ArrayList object
	static int tamanho(String find) {
		   int tamanho=0;  
		try {
		      File myObj = new File(find);
		      Scanner myReader = new Scanner(myObj);  
		     

		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        if(!data.contains(";") && !data.contains(",") && !data.contains(" ")){
		        	
		        	tamanho++;
		        }
		      }
		    
		      myReader.close();
		    } catch (FileNotFoundException e) {

			System.out.println("Ficheiro não encontrado");		    
			}
		return tamanho; 
	}
	 static void   mostrarfinal(int tamanho) {
		 	System.out.println();
			System.out.println();
			
			for(int i = 0 ; i < tamanho; i++){
				for(int j = 0 ; j < tamanho; j++)
				{
								
					System.out.print(arrayfinal[i][j]+" ");

				}
				System.out.println();
				
			}

	 }
	 static void verificador(String word) {
		 int count=0;
		for(int k=0;k<coretor.size();k++){
			if(coretor.get(k).equals(word)){
				count++;
			}							

			}
			if(count>1){
				System.out.printf("\n Erro no puzzle palavra {%s} so pode aparacer uma vez, refaz o puzzle\n ",word);
				System.exit(1);
			}
	 }
	 static void run(String find,int tamanho) {
		 File texto=new File(find);
		 	int coluna=0;
			int linha=0;
			int tamanhocontador=0;
			int totalletras=0;
			try {
				Scanner myRe= new Scanner(texto);
				String palavras[] = null;
				while(myRe.hasNextLine()) {
					
					String data=myRe.nextLine();
					
					if(!data.contains(";") && !data.contains(",") && !data.contains(" ") ) {
						
						//System.out.println(data);
						tamanhocontador++;
						for(int i=0; i<data.length();i++) {
							
							
								if(Character.isUpperCase(data.charAt(i)) && String.valueOf(data.charAt(i)).matches("[A-Z]*")) {
									totalletras++;
									array[linha][coluna]=data.charAt(i);
									arrayfinal[linha][coluna]='.';
									coluna++;	

									if(coluna>tamanho-1) { // se limitide coluna atingido volta para coluna zero na linha seguinte
										linha++;
										coluna=0;
									}
								
								}
								else {
									char s=data.charAt(i);
									if(s!=' ') {
										System.out.printf("Invalid Character {%s} found",data.charAt(i));
										System.exit(0);
									}
								}
							}
				
					}
					else {
							
						if(totalletras!=(tamanhocontador*tamanhocontador)) {
							System.out.println("Impossivel Jogar!O puzzle não é quadrado ou contem linhas vazias...");
							System.exit(1);
						}
						
						palavras=data.split("[\\s+;,]");
						
						for(int i=0;i<palavras.length;i++) {
							palavras[i]=palavras[i].toUpperCase();
							
							if(!palavras[i].isBlank()){
								resolvercoluna(palavras[i],tamanho);
								resolverlinha(palavras[i],tamanho);
								resolverdiagonal(palavras[i],tamanho);
								verificador(palavras[i]); //verifica se palavra esta repitida
							
							}
						
						}
			
					}					
				}
				mostrarfinal(tamanho);
				myRe.close();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Ficheiro n�o encontrado");
			}

		  }
	 
	 
	 static int resolvercoluna(String find,int tamanho) {
		
			//Trying vertical search 
		 
		 //--------Normal SEARCH--------

			 int found=0; //0 not found //1 found
			 int reverseline=tamanho-1;
			 String reversemode="";
			 if(!reversemode.equals("true")) {//normal search
				int lines=0;
				for(int cols=0;cols<tamanho;cols++) {
					//System.out.println(" coluna"+cols);
					
					while(lines!=tamanho-1) {
							
						if(array[lines][cols]==find.charAt(0)) {
							String partial="";

							external:
							
							for(int tt=lines;tt<tamanho;tt++) {

								partial=partial+array[tt][cols];
							
								if(partial.equals(find)) {
								
									coretor.add(partial);
									found=1;
									//System.out.printf("%s	%s	%s,%s  UP (reverse mode)\n ",partial,partial.length(),reverseline+1,cols+1); // mais um pmd na pdf indice ca ta cumesa de zero e sim de 1
									System.out.printf ("%-10s %5.7s  %5s,%s %12s\n", partial, partial.length(), lines+1,cols+1,"Down");
									//System.out.printf("Find %s at col %s line %s to line x (normal mode)\n ",partial,cols,lines); // mais um pmd na pdf indice ca ta cumesa de zero e sim de 1
									
									int encontrar=0;
									int contador=0;
									while(encontrar!=find.length()) {
										arrayfinal[lines+contador][cols]=array[lines+contador][cols];
										encontrar++;
										contador++;
									}

									break external;
								}else{
									reversemode="true";
								}
				
							}

						}
						lines++;	
	
					}
					lines=0; // pa pode avança 			
				}
			 }	

			 if(reversemode.equals("true")){

			 for(int cols=0;cols<tamanho;cols++) {
				 while(reverseline!=0) {
					 
					 if(array[reverseline][cols]==find.charAt(0)) {
						 String partial="";
							external:
							for(int tt=reverseline;tt>-1;tt--) {

								partial=partial+array[tt][cols];
							
								if(partial.equals(find)) {
									found+=1;
									coretor.add(partial);
									//System.out.printf("%s	%s	%s,%s  UP (reverse mode)\n ",partial,partial.length(),reverseline+1,cols+1); // mais um pmd na pdf indice ca ta cumesa de zero e sim de 1
									System.out.printf ("%-10s %5.7s %5s,%s %10s\n", partial, partial.length(), reverseline+1,cols+1,"UP");

									reversemode="true";
									int encontrar=0;
									int contador=0;
									while(encontrar!=find.length()) {
										arrayfinal[reverseline-contador][cols]=array[reverseline-contador][cols];
										encontrar++;
										contador++;
									}

									break external;
								}
				
							}

					 }
	
					 reverseline--;
				 }
				 reverseline=tamanho-1;
			 }
			}
			 
	
			return found;
	 }
	 
	 static int resolverlinha(String find,int tamanho) {
		int found=0; //0 not found //1 found

		 int cols=0;
		 String reversemode="true";
		 //-----Normal Search
		 for(int linhas=0;linhas<tamanho;linhas++) {
			 while(cols!=tamanho-1) {
				 //System.out.println(array[linhas][cols]);
				 if(array[linhas][cols]==find.charAt(0)) {
					 String partial="";
					 external:
					 for(int restante=cols;restante<tamanho;restante++) {
						 partial=partial+array[linhas][restante];		
						 if(partial.equals(find)) {
							coretor.add(partial);
							 found=1;
								System.out.printf ("%-10s %5.7s %5s,%s %14s\n", partial, partial.length(), linhas+1,cols+1,"Right");

							 //System.out.printf("Find %s at lines %s cols:%s to x (normal mode) \n",partial,linhas,cols);
							 //System.out.println(partial);
							 reversemode="false";
								int encontrar=0;
								int contador=0;
								while(encontrar!=find.length()) {								
									arrayfinal[linhas][cols+contador]=array[linhas][cols+contador];
									encontrar++;
									contador++;
								}
							 
							 break external;
						 }

					 }
				 }
				 cols++;
			 }

			 cols=0;
		 }

		 if(reversemode.equals("true")) {
			 cols=tamanho-1;
			 for(int linhas=0;linhas<tamanho;linhas++) {
				// System.out.println("-----linhas: "+linhas);

				 while(cols>-1) {
					 
					 if(array[linhas][cols]==find.charAt(0)) {
						 String partial="";
		 
						 external:
						 for(int restante=cols;restante>-1;restante--) {
							 partial=partial+array[linhas][restante];
							 if(partial.equals(find)) {
								 found=1;
								// System.out.println(partial);
									System.out.printf ("%-10s %5.7s %5s,%s %13s\n", partial, partial.length(), linhas+1,cols+1,"Left");

								 	//System.out.printf("Find %s at linha %s col %s to cols x (reverse mode)",partial,linhas,cols); // mais um pmd na pdf indice ca ta cumesa de zero e sim de 1
									
									int encontrar=0;
									int contador=0;
									while(encontrar!=find.length()) {
										arrayfinal[linhas][cols-contador]=array[linhas][cols-contador];
										encontrar++;
										contador++;
									}
								 
								 break external;
							 }
						 }

					 }

					 cols--;
				 }
				 cols=tamanho-1;

			 }
			 
		 }
		 return found;
	 }
	 //so resolve diagonal cima baixo (para esquerda)
	 static int resolverdiagonal(String word,int tamanho) {
		int found=0; //0 not found //1 found

		 String partial="";
	
		 for(int linhas=0;linhas<tamanho;linhas++) {
			 for(int colunas=0;colunas<tamanho;colunas++) {
				 if(array[linhas][colunas]==word.charAt(0)) {
					 //System.out.printf("\n -------linhas %s coluna %s charAT0_:%s\n ",linhas,colunas,array[linhas][colunas]);

					int i=linhas;
					
					
					if(linhas>colunas) {
						
						 String encontrado="";
						 partial="";
						int nextcolum=colunas;
						int lines=linhas;
						external:
						while(lines<tamanho) {
							//System.out.printf("\n%s %s words:%s",lines,nextcolum,array[lines][nextcolum]);
							//System.out.printf("\n%s %s %s",lines,nextcolum,array[lines][nextcolum]);
							partial+=array[lines][nextcolum];
							if(partial.equals(word)) {
								coretor.add(partial);
								found=1;
								encontrado="true";
								System.out.printf ("%-10s %5.7s  %5s,%s %13s\n", partial, partial.length(), linhas+1,colunas+1,"Dright");

								//System.out.printf("Find ***{%s} in diagonal baixo",partial);
								int c=colunas;
								int li=linhas;
								partial="";
							
								externals:
								while(li<tamanho) {
									if(c<tamanho) {
										partial+=array[li][c];
												
										arrayfinal[li][c]=array[li][c];
	
										if(partial.equals(word)) {
											//System.out.printf("\n %s ",partial);
											break externals;
										}

									}
									
									li++;
									c++;
								}
								
								
								break external;
							}
							
							lines++;
							nextcolum++;
						}
						
						if(!encontrado.equals("true")) {
							partial="";
							int nextline=linhas;
							int cols=colunas;
							external:
							while(nextline>-1) {
								if(cols>-1) {
									//System.out.printf("\nlines:%s cols:%s word:%s",nextline,cols,array[nextline][cols]);
									partial+=array[nextline][cols];
									//System.out.printf("\n%s %s letra:%s",nextline,cols,array[nextline][cols]);
									if(partial.equals(word)) {
										coretor.add(partial);
										found=1;
										//System.out.printf("\n---Find {%s} in diagonal cima  \n",partial);
										System.out.printf ("%-10s %5.7s  %5s,%s %13s\n", partial, partial.length(), linhas+1,colunas+1,"UPleft");

										int c=cols;
										int li=nextline;
										String partialverifi="";
										
										internals:
										while(li<tamanho) {
											if(c<tamanho) {
												partialverifi+=array[li][c];
												arrayfinal[li][c]=array[li][c];
												String inverse="";
												for(int ia=partialverifi.length()-1;ia>-1;ia--) {
													inverse+=partialverifi.charAt(ia);
													//System.out.printf("\n %s \n",ia);
												}
												if(inverse.equals(word)) {
													break internals;
												}

												
												
											}
											
											c++;
											li++;
										}
										break external;
										}
									
								}
								nextline--;
								cols--;
							}
						}
						
					}
					/// completo
					if(colunas>linhas) {

						 String encontrado="";
						partial="";
						int nextline=linhas;
						int cols=colunas;
						external:
						while(cols<tamanho) {
							//System.out.printf("\n%s %s letras:%s ",nextline,cols,array[nextline][cols]);
							partial+=array[nextline][cols];
							if(partial.equals(word)) {
								coretor.add(partial);
								found=1;
								encontrado="true";
								//System.out.printf("\n find {%s} in DIAGONAL BAIXO linha%s\n" ,partial,nextline);
								System.out.printf ("%-10s %5.7s  %5s,%s %13s\n", partial, partial.length(), linhas+1,colunas+1,"Dright");

								//System.out.printf("\n %s %s letra:%s\n",nextline,cols,array[nextline][cols]);
								int c=colunas;
								int li=linhas;
								String partialverifi="";
								internals:
								while(c<tamanho){
									if(li<tamanho) {
										partialverifi+=array[li][c];
										arrayfinal[li][c]=array[li][c];
										if(partialverifi.equals(partial)) {									
											break internals;
										}
									}
									li++;
									c++;
									
								}

								break external;
							}
							cols++;
							nextline++;
						}
						//reverse mode when cols>linhas
						//completo
						if(!encontrado.equals("true")) {
							//System.out.printf("\n-----reverse search----");
							partial="";
							nextline=linhas;
							cols=colunas;
							external:
							while(cols>-1) {
								if(nextline>-1) {
									//System.out.printf("\nlines:%s cols:%s word:%s",nextline,cols,array[nextline][cols]);

									partial+=array[nextline][cols];

									if(partial.equals(word)) {
										coretor.add(partial);
										found=1;
										String partialf="";
										
										System.out.printf ("%-10s %5.7s  %5s,%s %13s\n", partial, partial.length(), linhas+1,colunas+1,"Upleft");

										   
										   		// completando a tabela do array final com inicio(linhas e colunas) ate fim (encontradas) dos mesmos
												int c=colunas;
												int li=linhas;
												
												ex:
												while(c>-1) {
													if(li>-1) {
														partialf+=array[li][c];
														arrayfinal[li][c]=array[li][c];
														if(partialf.equals(partial)) {
															break ex;
														}
																										
													}
													c--;
													li--;
												}					
									}
								}
								cols--;
								nextline--;
							}
							
						}
						
						
					}
								
				//completo
					if(linhas==colunas) {
						 String encontrado="";
						 partial="";
							external:
							while(i<tamanho) {
								partial+=array[i][i];

								if(partial.equals(word)) {
									coretor.add(partial);
								
									found=1;
									encontrado="true";
									String partialf="";
									System.out.printf ("%-10s %5.7s  %5s,%s %13s\n", partial, partial.length(), linhas+1,colunas+1,"Dright");

									//System.out.printf("\n --Find {%s} em DIAGONAL BAIXO linhas %s \n",partial,i);
									//System.out.printf("\n------%s %s %s -----",i,i,array[i][i]);

									int c=linhas;
									ex:
									while(c<tamanho-1) {
										arrayfinal[c][c]=array[c][c];
										partialf+=array[c][c];
										//System.out.printf("\n------%s -----",partialf);
										if(partialf.equals(partial)){
											
											break ex;
										}
										//System.out.printf("\n------%s %s %s -----",c,c,array[c][c]);
										
										

										c++;
									}

									break external;
								}
		
								i++;
							}
							
							if(!encontrado.equals("true")) {

								partial="";
								i=linhas;
								external:
								while(i!=0) {
									partial+=array[i][i];
									//System.out.printf("\n %s  %s %s\n ",i,i,array[i][i]);

									if(partial.equals(word)) {
										found=1;
										coretor.add(partial);
										//System.out.printf("\n %s %s %s\n ",i,i,array[i][i]);
										//System.out.printf("\n ----Find {%s} em DIAGONAL CIMA",partial);
										System.out.printf ("%-10s %5.7s  %5s,%s %13s\n", partial, partial.length(), linhas+1,colunas+1,"UPleft");

										int c=i;
										while(c<11) {
											arrayfinal[c][c]=array[c][c];
											c++;
										}
										
										break external;
									}
									i--;
								}
							
						}
					}
				 
				 
				 }
				 
			 }
		 }
		 return found;
	 }
	 
	
	public static void main(String[] args) throws FileNotFoundException {

		// TODO Auto-generated method stub
		if(args.length==0 ){
			System.out.println("\nTem de passar um ficheiro como argumento\n");
			System.exit(1);
		}
		if(args.length>1){
			System.out.println("\nTem de passar um unico argumento\n");
			System.exit(1);
		}
		String nomeficheiro=nomeficheiro=args[0];
		if(!nomeficheiro.contains(".txt")){
			nomeficheiro+=".txt";
		}		
		String saida="";
		for(int i=0;i<nomeficheiro.length();i++) {
			saida+=nomeficheiro.charAt(i);
			
			if(nomeficheiro.charAt(i+1)=='.'){
				break;
			}
		}
		
		saida=saida+"_out01.txt";
		System.out.printf("\n Saida gerada no ficheiro {%s}",saida);
		System.setOut(new PrintStream(new FileOutputStream(saida)));
		System.out.println("Result:\n");
		int tamanho=tamanho(nomeficheiro);
		
		//Limitar que o tamanho seja no maximo 40
		
		if(tamanho>40) {
			System.out.println("Tamnho maximo excedido! impossivel jogar");
			System.exit(1);
		}		
		run(nomeficheiro,tamanho);
		
		
		

}
}