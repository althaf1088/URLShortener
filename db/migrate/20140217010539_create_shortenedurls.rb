class CreateShortenedurls < ActiveRecord::Migration
  def change
    create_table :shortenedurls do |t|
      t.string :shorturl
      t.integer :hits
      t.string :ipaddress

      t.timestamps
    end
  end
end
