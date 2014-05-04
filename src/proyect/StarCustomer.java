package proyect;

public class StarCustomer extends Customer {

	public Card fidelityCard;
	
	public double finalPrize;
	public double prizeCurrentProduct;
	public double counter;
	public int usedPointsInThisPurchase;
	
	
	
	//Constructor
	public StarCustomer(String name,String surnames,String DNI,Card fidelityCard){	
		
		this.name=name;
		this.surnames=surnames;
		this.DNI=DNI;
		this.fidelityCard=fidelityCard;
	
	}
	
	
	
	//Non mandatory method
	public double computePurchaseaAndCalculateRealPrize (SList <BoughtProduct> listBroughtProductsCurrentPurchase){ /*Computes the products of the current purchase and the points,
	                                                                                                              adds them to the list of bought products and updates the number 
	                                                                                                                 of accumulated points.*/
	
	fidelityCard.pointsInThisPurchase=0;
	double realPrize=0;
	double prizeCurrentProduct=0;
	
	for(SNode<BoughtProduct> node = listBroughtProductsCurrentPurchase.getFirstNode(); node != null; node = node.nextNode){
		
		prizeCurrentProduct=node.getElement().prize;
		realPrize +=prizeCurrentProduct ;
		
		if(prizeCurrentProduct<fidelityCard.pointRule1){
			fidelityCard.pointsInThisPurchase+=fidelityCard.pointRule3;
			node.getElement().pointsAssociated=fidelityCard.pointRule3;// Assigns points to the current product according to the rule
		}
		
		if(prizeCurrentProduct>=fidelityCard.pointRule1 && prizeCurrentProduct<=fidelityCard.pointRule2){
			fidelityCard.pointsInThisPurchase+=fidelityCard.pointRule4;
			node.getElement().pointsAssociated=fidelityCard.pointRule4;
		}
		if(prizeCurrentProduct>fidelityCard.pointRule2){
			fidelityCard.pointsInThisPurchase+=fidelityCard.pointRule5;
			node.getElement().pointsAssociated=fidelityCard.pointRule5;
		}
		
		                   }
	
	            return realPrize;
	
	
	}
	
	
	//Mandatory method.	
	public void pay(double realPrize){
		
		int numberOfDiscounts;
		// First we calculate the final prize for the purchase.
		if (fidelityCard.accumulatedPoints<10){
			
			 numberOfDiscounts=0;
			 System.out.println("No discount .The prize of the purchase is"+realPrize);
		}
		
		
		else {
            
			 numberOfDiscounts= (int)(fidelityCard.accumulatedPoints/fidelityCard.ratioPoints); 
			
			/* As the number of points will not be always a multiple of ten (ratio points) we have to 
			 * do this division so that we can calculate how many times there is a discount of 5% 
			 * and also how many points do we have to use and how many points there will be at the end of 
			 * the process (update points)
			 */
			
			if(numberOfDiscounts <4){
			
			/* Now we calculate the euro we have to substract to the real prize 
			 * multiplying a multiple of ten (points used) by the discount for every ten points.
			 */
			
			 finalPrize= realPrize - (numberOfDiscounts*fidelityCard.valueDicountEveryTenPoints);
			
			 System.out.println("The final prize(applying its corresponding discount)is"+finalPrize+" euros.");
				
			}
			
			if (numberOfDiscounts >=4){
			
			// Real prize if the purchase minus 20% of that purchase.
				
			finalPrize= realPrize - (fidelityCard.maxDiscountWholePurchase*realPrize);
			System.out.println("The final prize(applying its corresponding discount)is"+finalPrize+" euros.");		
					
			//Now let's update the number of points and the products whose points have already been used 		
					
				usedPointsInThisPurchase=0;
				
	         if(numberOfDiscounts==0){
	        	 // The number of used points is still 0.
	         }
				
			if(numberOfDiscounts!=0){
				
			if(numberOfDiscounts <4){
				usedPointsInThisPurchase = (int) (numberOfDiscounts* fidelityCard.ratioPoints); // Calculates the number of points used.
				              } 
      
			
			if (numberOfDiscounts >=4){
				usedPointsInThisPurchase =(int) (fidelityCard.ratioPoints* fidelityCard.maxNumberDiscount);		
			               }
			    
			
			
			/* In this case , as we apply a 20 % for the whole purchase and 10 points correspond to a 5% discount in the 
			 * next acquisition , the number of points to be used will be 40.
			 * Let´s delete products until the number of points is 40. 	
			 */
			
		
			     counter=0;
				
				while(counter!=usedPointsInThisPurchase){
					counter= fidelityCard.listBroughtProducts.getFirst().pointsAssociated;
					fidelityCard.listBroughtProducts.removeFirst(); // Deletes products whose points have been used.			
				
				/*As we don not have to take into account the products in the current purchase , we have to delete products 
				 * from the beginning, because this list is sorted by date. 		
				 */
				
				                                  }
				
			for(SNode<BoughtProduct> node = fidelityCard.listBroughtProductsCurrentPurchase.getFirstNode(); node != null;
						node = node.nextNode){
				fidelityCard.listBroughtProducts.addLast(node.getElement());
				fidelityCard.listBroughtProductsCurrentPurchase.removeFirst();
					
				                            }
			
			//Updates both lists. We do this now because the points of the current purchase cannot be used.
					
			                        }
			                    }
					        }
			             }
	                  
   
                }

	

