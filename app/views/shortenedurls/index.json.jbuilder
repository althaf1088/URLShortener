json.array!(@shortenedurls) do |shortenedurl|
  json.extract! shortenedurl, :id, :shorturl, :hits, :ipaddress
  json.url shortenedurl_url(shortenedurl, format: :json)
end
