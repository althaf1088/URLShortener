class ShortenedurlsController < ApplicationController
  before_action :set_shortenedurl, only: [:show, :edit, :update, :destroy]

  # GET /shortenedurls
  # GET /shortenedurls.json
  def index
    @shortenedurls = Shortenedurl.all
  end

  # GET /shortenedurls/1
  # GET /shortenedurls/1.json
  def show
  end

  # GET /shortenedurls/new
  def new
    @shortenedurl = Shortenedurl.new
  end

  # GET /shortenedurls/1/edit
  def edit
  end

  # POST /shortenedurls
  # POST /shortenedurls.json
  def create
    @shortenedurl = Shortenedurl.new(shortenedurl_params)

    respond_to do |format|
      if @shortenedurl.save
        format.html { redirect_to @shortenedurl, notice: 'Shortenedurl was successfully created.' }
        format.json { render action: 'show', status: :created, location: @shortenedurl }
      else
        format.html { render action: 'new' }
        format.json { render json: @shortenedurl.errors, status: :unprocessable_entity }
      end
    end
  end

  # PATCH/PUT /shortenedurls/1
  # PATCH/PUT /shortenedurls/1.json
  def update
    respond_to do |format|
      if @shortenedurl.update(shortenedurl_params)
        format.html { redirect_to @shortenedurl, notice: 'Shortenedurl was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: 'edit' }
        format.json { render json: @shortenedurl.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /shortenedurls/1
  # DELETE /shortenedurls/1.json
  def destroy
    @shortenedurl.destroy
    respond_to do |format|
      format.html { redirect_to shortenedurls_url }
      format.json { head :no_content }
    end
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_shortenedurl
      @shortenedurl = Shortenedurl.find(params[:id])
    end

    # Never trust parameters from the scary internet, only allow the white list through.
    def shortenedurl_params
      params.require(:shortenedurl).permit(:shorturl, :hits, :ipaddress)
    end
end
