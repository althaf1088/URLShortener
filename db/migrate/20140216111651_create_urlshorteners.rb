class CreateUrlshorteners < ActiveRecord::Migration
  def change
    create_table :urlshorteners do |t|
      t.string :url
      t.string :count

      t.timestamps
    end
  end
end
