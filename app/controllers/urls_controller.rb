
  class UrlsController < ApplicationController
    skip_before_action :verify_authenticity_token
    respond_to :json, :xml
  
  ALPHABET =
  "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".split(//)
  
  #Method to display the list of requests
  def index
    @urls = Url.all
    respond_to do |format|
      format.html # index.html.erb
      format.xml  { render xml: @urls}
      format.json { render json: @urls }
  end
  end
 
 #Method to create a shortened URL and Store it 
   def create
    @shortened_url = Url.new(:url => params[:url])
    
    
    respond_to do |format|
       if @shortened_url.save
        @num=""
         flash[:shortened_id] = @shortened_url.id
        ( @shortened_url.id..(@shortened_url.id)).each do |i|
          @num=hashing(i)+@num
       end
      @shortened_url.shorturl=url_url(@num)   
      @shortened_url.save       
      
       format.html {redirect_to new_url_url}
       format.xml  { render xml: @urls}
       format.json { render json: @shortened_url, status: :created }
      else
        format.json { render json: @shortened_url.errors, status: :unprocessable_entity }
    end
    end
   end
    
    #Method to create a hashed alphanumeric value for the Integer URL id
   def hashing(i)
  
   return ALPHABET[0] if i == 0
    hash = ''
    base = ALPHABET.length
    while i > 0
      hash<< ALPHABET[i.modulo(base)]
      i /= base
    end
    hash.reverse
  end
  
  #Methode to retrieve the URL ID given a alphanumeric value
  def hashing_decode(s)
  
  i = 0
  base = ALPHABET.length
  s.each_char { |c| i = i * base + ALPHABET.index(c) }
  i
  end
  
  #Method to validate url
    def url_params
     params.require(:url).permit(:url)
    end
  
  #Method where a new URL object is created
    def new
      @shortened_url = Url.new
      
    end

 #Method to fetch the list of all URL's
  def view
   @urls = Url.find(:all)
   redirect_to @list_url.url
  end
  
  
#Method to redirect to the shortened URL and also to increment the access count
  def show
    @decode=hashing_decode(params[:id])
    @shortened_url = Url.find(@decode)
    if (@shortened_url.hits!=nil)
      
    @shortened_url.hits=@shortened_url.hits+1
    else
    
    @shortened_url.hits=1
  end
    @shortened_url.save 
    redirect_to @shortened_url.url
  end
  
  #Method to fetch the details of requested URL
  def edit
    
    @decode=hashing_decode(params[:id])
    @shortened_url = Url.find(@decode)
   
    respond_to do |format|
    format.json { render json: @shortened_url}
  end
  end
end
